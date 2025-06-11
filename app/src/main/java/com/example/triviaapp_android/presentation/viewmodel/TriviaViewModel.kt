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

    private val _HomeUIState = MutableStateFlow<HomeUIState>(
        HomeUIState()
    )
    val homeUIState = _HomeUIState.asStateFlow()

    private val _apiState = MutableStateFlow<ApiState>(
        ApiState()
    )

    private val _questionUiState = MutableStateFlow<QuestionUIState>(
        QuestionUIState()
    )


    fun getQuestions() {
        viewModelScope.launch {
            val questions = triviaRepository.getQuestions(
                amount = _apiState.value.amount,
                category = _apiState.value.category,
                difficulty = _apiState.value.difficulty
            )
            _questions.value = questions.results

            Log.d("viewModel", questions.toString())

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
}