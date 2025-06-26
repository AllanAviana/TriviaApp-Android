package com.example.triviaapp_android.presentation.UIStates.progress

import com.example.triviaapp_android.R

data class ProgressUIState(
    val total: Float = 500f,
    val progress: Float = 0f,
    val points: Int = 0,
    val medal: Int = R.drawable.medal,
    val cardList: List<ProgressCard> = listOf(
        ProgressCard(
            category = "Sports",
            image = R.drawable.sportsicon,
            gameCount = 0,
            score = 0
        ),
        ProgressCard(
            category = "Geography",
            image = R.drawable.gegographyicon,
            gameCount = 0,
            score = 0
        ),
        ProgressCard(
            category = "History",
            image = R.drawable.historyicon2,
            gameCount = 0,
            score = 0
        ),
        ProgressCard(
            category = "Anime",
            image = R.drawable.animeicon,
            gameCount = 0,
            score = 0
        )
    )
)
