package com.example.triviaapp_android.data.contracts

import com.example.triviaapp_android.data.remote.TriviaResponse

interface TriviaRepository {
    suspend fun getQuestions(amount: Int, category: Int, difficulty: String): TriviaResponse
}