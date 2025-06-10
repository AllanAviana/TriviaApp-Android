package com.example.triviaapp_android.presentation.UIStates.home

import com.example.triviaapp_android.R

data class HomeUIState(
    val cardList: List<CardState> = listOf(
        CardState(
            category = "Sports",
            categoryId = 21,
            image = R.drawable.man
        ),
        CardState(
            category = "Geography",
            categoryId = 22,
            image = R.drawable.location
        ),
        CardState(
            category = "History",
            categoryId = 23,
            image = R.drawable.sparta
        ),
        CardState(
            category = "Anime",
            categoryId = 31,
            image = R.drawable.pokebola
        )
    )
)

