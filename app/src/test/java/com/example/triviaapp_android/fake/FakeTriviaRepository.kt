package com.example.triviaapp_android.fake

import com.example.triviaapp_android.data.contracts.TriviaRepository
import com.example.triviaapp_android.data.remote.Question
import com.example.triviaapp_android.data.remote.TriviaResponse

class FakeTriviaRepository(
    var result: TriviaResponse = TriviaResponse(
        results = listOf(
            Question(
                type = "multiple",
                difficulty = "easy",
                category = "General",
                question = "What is 2 + 2?",
                correct_answer = "4",
                incorrect_answers = listOf("3", "5", "22")
            ),
            Question(
                type = "multiple",
                difficulty = "easy",
                category = "General",
                question = "Capital of France?",
                correct_answer = "Paris",
                incorrect_answers = listOf("London", "Berlin", "Madrid")
            )
        ),
        response_code = 1
    )
) : TriviaRepository {

    override suspend fun getQuestions(
        amount: Int,
        category: Int,
        difficulty: String
    ): TriviaResponse = result
}