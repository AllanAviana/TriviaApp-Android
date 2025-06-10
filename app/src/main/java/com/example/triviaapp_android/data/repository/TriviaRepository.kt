package com.example.triviaapp_android.data.repository

import com.example.triviaapp_android.data.api.TriviaApi
import com.example.triviaapp_android.data.remote.TriviaResponse
import javax.inject.Inject

class TriviaRepository @Inject constructor(
    private val api: TriviaApi
) {
    suspend fun getQuestions(amount: Int, category: Int, difficulty: String): TriviaResponse{
       return api.getTriviaQuestions(amount,category,difficulty)
    }
}