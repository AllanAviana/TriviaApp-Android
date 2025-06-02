package components

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun loginGradient() = Brush.linearGradient(
    colorStops = arrayOf(
        0.0f to Color(0xFF2CA7CE),
        1.0f to Color(0xFF6FC2DC)
    )
)