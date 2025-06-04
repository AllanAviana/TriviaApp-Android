package com.example.triviaapp_android.presentation.screen.difficultyselection.components

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun DifficultySelectionGradient() = Brush.linearGradient(
    colorStops = arrayOf(
        0.0f  to Color(0xFF13384D),
        0.35f to Color(0xFF0D2F4A),
        1.0f  to Color(0xFF011C44)
    )
)