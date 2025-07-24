// app/src/test/java/com/example/triviaapp_android/viewmodel/TriviaViewModelTest.kt
package com.example.triviaapp_android.viewmodel

import com.example.triviaapp_android.fake.FakeStatsRepository
import com.example.triviaapp_android.fake.FakeTriviaRepository
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel
import com.example.triviaapp_android.presentation.UIStates.question.QuestionUIState
import com.example.triviaapp_android.presentation.UIStates.result.ResultUIState
import com.example.triviaapp_android.util.MainDispatcherRule
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class TriviaViewModelTest {

    @get:Rule
    val mainRule = MainDispatcherRule()

    @Test
    fun `getQuestions loads and fills first QuestionUIState`() = runTest {
        val vm = TriviaViewModel(
            triviaRepository = FakeTriviaRepository(),
            statsRepository  = FakeStatsRepository()
        )

        vm.getQuestions()
        advanceUntilIdle()

        val qState = vm.questionUiState.value
        assertEquals("What is 2 + 2?", qState.question)
        assertEquals("4", qState.correctAnswer)
        assertFalse(qState.finished)
        assertEquals(4, qState.options.size)
    }

    @Test
    fun `updateQuestionUIState consumes list and sets finished when empty`() = runTest {
        val vm = TriviaViewModel(
            triviaRepository = FakeTriviaRepository(),
            statsRepository  = FakeStatsRepository()
        )

        vm.getQuestions()
        advanceUntilIdle()

        vm.updateQuestionUIState()
        var qState = vm.questionUiState.value
        assertEquals("Capital of France?", qState.question)
        assertEquals("Paris", qState.correctAnswer)
        assertFalse(qState.finished)

        vm.updateQuestionUIState()
        qState = vm.questionUiState.value
        assertTrue(qState.finished)
    }

    @Test
    fun `resetUIStates clears question and result states`() = runTest {
        val vm = TriviaViewModel(
            triviaRepository = FakeTriviaRepository(),
            statsRepository  = FakeStatsRepository()
        )

        vm.getQuestions()
        advanceUntilIdle()

        vm.resetUIStates()

        val q = vm.questionUiState.value
        val r = vm.resultUIState.value
        assertEquals(QuestionUIState(), q)
        assertEquals(ResultUIState(), r)
    }

    @Test
    fun `checkAnswer updates score and points when correct`() = runTest {
        val vm = TriviaViewModel(
            triviaRepository = FakeTriviaRepository(),
            statsRepository  = FakeStatsRepository()
        )
        vm.getQuestions()
        advanceUntilIdle()

        val correct = vm.questionUiState.value.correctAnswer
        vm.checkAnswer(correct)

        val result = vm.resultUIState.value
        assertEquals(1, result.score)
        assertEquals(100, result.points)
    }

    @Test
    fun `checkAnswer does not increment score when wrong`() = runTest {
        val vm = TriviaViewModel(
            triviaRepository = FakeTriviaRepository(),
            statsRepository  = FakeStatsRepository()
        )
        vm.getQuestions()
        advanceUntilIdle()

        vm.checkAnswer("WRONG")

        val result = vm.resultUIState.value
        assertEquals(0, result.score)
        assertEquals(0, result.points)
    }

    @Test
    fun `updateLastPlayed updates states and calls saveLastPlayed`() = runTest {
        val fakeStats = FakeStatsRepository()
        val vm = TriviaViewModel(
            triviaRepository = FakeTriviaRepository(),
            statsRepository  = fakeStats
        )

        vm.updateLastPlayed("Sports")
        advanceUntilIdle()

        val result = vm.resultUIState.value
        val home   = vm.homeUIState.value

        assertEquals("Sports", result.category)
        assertTrue(home.isPlayed)
        assertEquals("Sports", home.lastPlayed.category)

        assertEquals(1, fakeStats.saveLastPlayedCalls)
        assertNotNull(fakeStats.lastSavedHome)
        assertEquals("Sports", fakeStats.lastSavedHome?.lastPlayed?.category)
    }

    @Test
    fun `updateStatistics updates progress and calls saveStats`() = runTest {
        val fakeStats = FakeStatsRepository()
        val vm = TriviaViewModel(
            triviaRepository = FakeTriviaRepository(),
            statsRepository  = fakeStats
        )

        val initialPoints = vm.progressUIState.value.points

        vm.updateStatistics(points = 300, category = "Sports")
        advanceUntilIdle()

        val progress = vm.progressUIState.value
        assertEquals(initialPoints + 300, progress.points)

        val sportsCard = progress.cardList.firstOrNull { it.category == "Sports" }
        assertNotNull(sportsCard)
        assertTrue((sportsCard?.gameCount ?: 0) > 0)

        assertEquals(1, fakeStats.saveStatsCalls)
        assertEquals(progress.points, fakeStats.lastSavedStats?.points)
    }
}
