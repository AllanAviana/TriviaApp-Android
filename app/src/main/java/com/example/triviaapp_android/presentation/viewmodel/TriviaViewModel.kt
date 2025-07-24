package com.example.triviaapp_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp_android.R
import com.example.triviaapp_android.data.contracts.StatsRepository
import com.example.triviaapp_android.data.contracts.TriviaRepository
import com.example.triviaapp_android.data.remote.Question
import com.example.triviaapp_android.presentation.UIStates.api.ApiState
import com.example.triviaapp_android.presentation.UIStates.home.HomeUIState
import com.example.triviaapp_android.presentation.UIStates.home.LastPlayedState
import com.example.triviaapp_android.presentation.UIStates.progress.ProgressUIState
import com.example.triviaapp_android.presentation.UIStates.question.QuestionUIState
import com.example.triviaapp_android.presentation.UIStates.result.ResultUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TriviaViewModel @Inject constructor(
    //region DEPENDENCIES
    private val triviaRepository: TriviaRepository,
    private val statsRepository: StatsRepository
    //endregion
) : ViewModel() {

    //region STATE FLOWS
    private val _questions        = MutableStateFlow<List<Question>>(emptyList())

    private val _homeUIState      = MutableStateFlow(HomeUIState())
    val   homeUIState             = _homeUIState.asStateFlow()

    private val _apiState         = MutableStateFlow(ApiState())

    private val _questionUiState  = MutableStateFlow(QuestionUIState())
    val   questionUiState         = _questionUiState.asStateFlow()

    private val _resultUIState    = MutableStateFlow(ResultUIState())
    val   resultUIState           = _resultUIState.asStateFlow()

    private val _progressUIState  = MutableStateFlow(ProgressUIState())
    val   progressUIState         = _progressUIState.asStateFlow()
    //endregion

    //region INITIALIZATION
    init {
        viewModelScope.launch {
            statsRepository.loadStats()?.let { _progressUIState.value = it }
            statsRepository.loadLastPlayed()?.let { _homeUIState.value = it }
        }
    }
    //endregion

    //region TRIVIA API
    fun getQuestions() = viewModelScope.launch {
        val questions = triviaRepository.getQuestions(
            amount     = _apiState.value.amount,
            category   = _apiState.value.category,
            difficulty = _apiState.value.difficulty
        )
        _questions.value = questions.results
        updateQuestionUIState()
    }

    fun updateCategory(category: Int)   { _apiState.value = _apiState.value.copy(category   = category) }
    fun updateDifficulty(difficulty: String) { _apiState.value = _apiState.value.copy(difficulty = difficulty) }

    fun updateQuestionUIState() {
        if (_questions.value.isNotEmpty()) {
            _questionUiState.value = _questionUiState.value.copy(
                question      = _questions.value[0].question,
                options       = _questions.value[0].incorrect_answers
                    .plus(_questions.value[0].correct_answer)
                    .shuffled(),
                correctAnswer = _questions.value[0].correct_answer
            )
            _questions.value = _questions.value.drop(1)
        } else {
            _questionUiState.value = _questionUiState.value.copy(finished = true)
        }
    }
    //endregion

    //region GAME HELPERS
    fun resetUIStates() {
        _questionUiState.value = QuestionUIState()
        _resultUIState.value   = ResultUIState()
    }

    fun reset(){
        _questionUiState.value = QuestionUIState()
        _resultUIState.value   = ResultUIState()
        _homeUIState.value     = HomeUIState()
        _progressUIState.value = ProgressUIState()
    }

    fun checkAnswer(answer: String) {
        val isCorrect = _questionUiState.value.correctAnswer == answer
        if (isCorrect) {
            _resultUIState.update { it.copy(score = it.score + 1, points = it.points + 100) }
        }
        _resultUIState.update { it.withTrophyInfo() }
    }

    private fun ResultUIState.withTrophyInfo(): ResultUIState = when (score) {
        in 0..2 -> copy(
            text  = "The outcome was disastrous. Better luck next time!",
            image = R.drawable.trophy3,
            word  = "Disastrous"
        )
        in 3..4 -> copy(
            text  = "You're getting there! Not perfect, but a solid effort!",
            image = R.drawable.trophy2,
            word  = "Getting there"
        )
        else    -> copy(
            text  = "Perfect score! You’re a trivia master!",
            image = R.drawable.trophy,
            word  = "Perfect"
        )
    }
    //endregion

    //region LAST PLAYED
    fun updateLastPlayed(category: String) {
        _resultUIState.update { it.copy(category = category) }
        _homeUIState.update { it.withCategory(category) }

        viewModelScope.launch {
            runCatching { statsRepository.saveLastPlayed(_homeUIState.value) }
                .onFailure { Log.e("TriviaVM", "Failed to save lastPlayed", it) }
        }
    }

    private fun HomeUIState.withCategory(cat: String): HomeUIState = when (cat) {
        "Sports"    -> copy(lastPlayed = LastPlayedState("Sports",    21, R.drawable.field,     R.drawable.ball),       isPlayed = true)
        "Geography" -> copy(lastPlayed = LastPlayedState("Geography", 22, R.drawable.earth,     R.drawable.globe),      isPlayed = true)
        "History"   -> copy(lastPlayed = LastPlayedState("History",   23, R.drawable.history,   R.drawable.historyicon),isPlayed = true)
        "Anime"     -> copy(lastPlayed = LastPlayedState("Anime",     31, R.drawable.dragon,    R.drawable.animeicon),  isPlayed = true)
        else        -> this
    }
    //endregion

    //region STATISTICS
    fun updateStatistics(points: Int, category: String) {
        _progressUIState.update { state ->
            val updatedCards = state.cardList.map { card ->
                if (card.category == category)
                    card.copy(gameCount = card.gameCount + 1, score = card.score + points)
                else card
            }
            val newPoints = state.points + points
            state.copy(
                points   = newPoints,
                progress = newPoints / state.total,
                cardList = updatedCards,
                medal    = when (newPoints) {
                    in   0 ..199 -> R.drawable.medal
                    in 200 ..499 -> R.drawable.medal2
                    else         -> R.drawable.medal3
                }
            )
        }

        viewModelScope.launch {
            runCatching { statsRepository.saveStats(_progressUIState.value) }
                .onFailure { Log.e("TriviaVM", "Failed to save stats", it) }
        }
    }

    fun loadStats() = viewModelScope.launch {
        runCatching { statsRepository.loadStats() }
            .onSuccess { it?.let { _progressUIState.value = it } }
            .onFailure { Log.e("TriviaVM", "Failed to load stats", it) }
    }

    fun loadLastPlayed() = viewModelScope.launch {
        runCatching { statsRepository.loadLastPlayed() }
            .onSuccess { it?.let { _homeUIState.value = it } }
            .onFailure { Log.e("TriviaVM", "Failed to load lastPlayed", it) }
    }
    //endregion
}
