package com.example.triviaapp_android.data.remote

data class TriviaResponse(
    val response_code: Int,
    val results: List<Question>
)
