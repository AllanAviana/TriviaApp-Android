package com.example.triviaapp_android.presentation.UIStates

data class QuestionUIState(
    val question: String = "",
    val options: List<String> = emptyList(),
    val correctAnswer: String = "",
    val selectedAnswer: String = "",
    val isCorrect: Boolean = false,
    val finished: Boolean = false
)
