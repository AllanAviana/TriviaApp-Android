package com.example.triviaapp_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp_android.R
import com.example.triviaapp_android.data.remote.Question
import com.example.triviaapp_android.data.repository.TriviaRepository
import com.example.triviaapp_android.presentation.UIStates.QuestionUIState
import com.example.triviaapp_android.presentation.UIStates.api.ApiState
import com.example.triviaapp_android.presentation.UIStates.home.HomeUIState
import com.example.triviaapp_android.presentation.UIStates.home.LastPlayedState
import com.example.triviaapp_android.presentation.UIStates.result.ResultUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    private val _resultUIState = MutableStateFlow(
        ResultUIState()
    )
    val resultUIState = _resultUIState.asStateFlow()

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
        if (_questions.value.isNotEmpty()) {
            _questionUiState.value = _questionUiState.value.copy(
                question = _questions.value[0].question,
                options = _questions.value[0].incorrect_answers.plus(_questions.value[0].correct_answer)
                    .shuffled(),
                correctAnswer = _questions.value[0].correct_answer
            )
            Log.d("viewModel", _questionUiState.value.toString())
            _questions.value = _questions.value.drop(1)
        } else {
            _questionUiState.value = _questionUiState.value.copy(
                finished = true
            )
        }
    }

    fun resetUIStates() {
        _questionUiState.value = _questionUiState.value.copy(
            question = "",
            options = emptyList(),
            correctAnswer = "",
            selectedAnswer = "",
            isCorrect = false,
            finished = false
        )
        _resultUIState.value = _resultUIState.value.copy(
            score = 0,
            points = 0,
            text = "",
            image = 0,
            word = ""
        )
    }

    fun checkAnswer(answer: String) {
        val isCorrect = _questionUiState.value.correctAnswer == answer

        if (isCorrect) {
            _resultUIState.update {
                it.copy(
                    score = it.score + 1,
                    points = it.points + 100
                )
            }
        }

        when (_resultUIState.value.score) {
            in 0..2 -> {
                _resultUIState.update {
                    it.copy(
                        text = "The outcome was disastrous. Better luck next time!",
                        image = R.drawable.trophy3,
                        word = "Disastrous"
                    )
                }
            }

            in 3..4 -> {
                _resultUIState.update {
                    it.copy(
                        text = "You're getting there! Not perfect, but a solid effort!",
                        image = R.drawable.trophy2,
                        word = "Getting there"
                    )
                }
            }

            else -> {
                _resultUIState.update {
                    it.copy(
                        text = "Perfect score! You’re a trivia master!",
                        image = R.drawable.trophy,
                        word = "Perfect"
                    )
                }
            }
        }
    }

    fun updateLastPlayed(category: String) {
        when (category) {
            "Sports" -> {
                _HomeUIState.update {
                    it.copy(
                        lastPlayed = LastPlayedState(
                            category = "Sports",
                            categoryId = 21,
                            image = R.drawable.field,
                            mainImage = R.drawable.ball
                        ),
                        isPlayed = true
                    )
                }
            }

            "Geography" -> {
                _HomeUIState.update {
                    it.copy(
                        lastPlayed = LastPlayedState(
                            category = "Geography",
                            categoryId = 22,
                            image = R.drawable.earth,
                            mainImage = R.drawable.globe
                        ),
                        isPlayed = true
                    )
                }
            }

            "History" -> {
                _HomeUIState.update {
                    it.copy(
                        lastPlayed = LastPlayedState(
                            category = "History",
                            categoryId = 23,
                            image = R.drawable.history,
                            mainImage = R.drawable.historyicon
                        ),
                        isPlayed = true
                    )
                }
            }

            "Anime" -> {
                _HomeUIState.update {
                    it.copy(
                        lastPlayed = LastPlayedState(
                            category = "Anime",
                            categoryId = 31,
                            image = R.drawable.dragon,
                            mainImage = R.drawable.animeicon
                        ),
                        isPlayed = true
                    )
                }
            }
        }
        Log.d("viewModel2", _HomeUIState.value.toString())
    }
}