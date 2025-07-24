package com.example.triviaapp_android.data.repository

import com.example.triviaapp_android.data.contracts.TriviaApi
import com.example.triviaapp_android.data.contracts.TriviaRepository
import com.example.triviaapp_android.data.remote.TriviaResponse
import javax.inject.Inject

class TriviaRepositoryImpl @Inject constructor(
    private val api: TriviaApi
) : TriviaRepository {

    override suspend fun getQuestions(
        amount: Int,
        category: Int,
        difficulty: String
    ): TriviaResponse = api.getTriviaQuestions(amount, category, difficulty)
}