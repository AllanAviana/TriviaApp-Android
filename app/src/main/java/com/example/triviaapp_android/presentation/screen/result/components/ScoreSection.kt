package components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreSection(score: Int) {
    Text(
        text = "Your Score:",
        color = Color.White,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxWidth(0.85f),
        textAlign = TextAlign.Center
    )

    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Green)) {
                append("$score")
            }
            withStyle(style = SpanStyle(color = Color.White)) {
                append("/5")
            }
        },
        fontSize = 48.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(0.85f),
        textAlign = TextAlign.Center
    )
}
