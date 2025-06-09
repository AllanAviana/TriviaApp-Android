package com.example.triviaapp_android.presentation.screen.result.components

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun resultGradient() = Brush.verticalGradient(
    colorStops = arrayOf(
        0.0f to Color(0xFF13384D),
        1.0f to Color(0xFF2C82B3)
    )
)