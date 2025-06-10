package com.example.triviaapp_android.data.api

import com.example.triviaapp_android.data.remote.TriviaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApi {
    @GET("api.php")
    suspend fun getTriviaQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String = "multiple"
    ): TriviaResponse
}