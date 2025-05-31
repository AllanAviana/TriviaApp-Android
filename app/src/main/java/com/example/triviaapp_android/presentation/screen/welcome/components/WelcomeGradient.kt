package com.example.triviaapp_android.presentation.screen.welcome.components

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun welcomeGradient() = Brush.linearGradient(
    colorStops = arrayOf(
        0.35f to Color(0xFF078AD2),
        1.0f to Color(0xFF4BA6D8)
    )
)