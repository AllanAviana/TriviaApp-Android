package com.example.triviaapp_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp_android.data.remote.Question
import com.example.triviaapp_android.data.repository.TriviaRepository
import com.example.triviaapp_android.presentation.UIStates.QuestionUIState
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

    private val _HomeUIState = MutableStateFlow<HomeUIState>(
        HomeUIState()
    )
    val homeUIState = _HomeUIState.asStateFlow()

    private val _questionUiState = MutableStateFlow<QuestionUIState>(
        QuestionUIState()
    )

    init {
        getQuestions(5, 21, "easy")
    }

    fun getQuestions(amount: Int, category: Int, difficulty: String) {
        viewModelScope.launch {
            val questions = triviaRepository.getQuestions(
                amount = amount,
                category = category,
                difficulty = difficulty
            )
            _questions.value = questions.results

            Log.d("Questions", questions.toString())

        }
    }
}