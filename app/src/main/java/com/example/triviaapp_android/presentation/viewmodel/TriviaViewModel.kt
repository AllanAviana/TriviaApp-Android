package com.example.triviaapp_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp_android.data.remote.Question
import com.example.triviaapp_android.data.repository.TriviaRepository
import com.example.triviaapp_android.presentation.UIStates.QuestionUIState
import com.example.triviaapp_android.presentation.UIStates.api.ApiState
import com.example.triviaapp_android.presentation.UIStates.home.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TriviaViewModel @Inject constructor(
    private val triviaRepository: TriviaRepository
) : ViewModel() {
    private val _questions = MutableStateFlow<List<Question>>(emptyList())

    private val _HomeUIState = MutableStateFlow(
        HomeUIState()
    )
    val homeUIState = _HomeUIState.asStateFlow()

    private val _apiState = MutableStateFlow(
        ApiState()
    )

    private val _questionUiState = MutableStateFlow(
        QuestionUIState()
    )

    val questionUiState = _questionUiState.asStateFlow()

    fun getQuestions() {
        viewModelScope.launch {
            val questions = triviaRepository.getQuestions(
                amount = _apiState.value.amount,
                category = _apiState.value.category,
                difficulty = _apiState.value.difficulty
            )
            _questions.value = questions.results

            Log.d("viewModel", questions.toString())

            updateQuestionUIState()
        }
    }

    fun updateCategory(category: Int) {
        _apiState.value = _apiState.value.copy(category = category)
        Log.d("viewModel", _apiState.value.toString())
    }

    fun updateDifficulty(difficulty: String) {
        _apiState.value = _apiState.value.copy(difficulty = difficulty)
        Log.d("viewModel", _apiState.value.toString())

    }

    fun updateQuestionUIState() {
        if (!_questions.value.isEmpty()) {
            _questionUiState.value = _questionUiState.value.copy(
                question = _questions.value[0].question,
                options = _questions.value[0].incorrect_answers.plus(_questions.value[0].correct_answer)
                    .shuffled(),
                correctAnswer = _questions.value[0].correct_answer
            )
            _questions.value = _questions.value.drop(1)
        }else{
            _questionUiState.value = _questionUiState.value.copy(
                finished = true
            )
        }
    }

    fun resetQuestionUIState() {
        _questionUiState.value = _questionUiState.value.copy(
            question = "",
            options = emptyList(),
            correctAnswer = "",
            selectedAnswer = "",
            isCorrect = false,
        )
    }
}