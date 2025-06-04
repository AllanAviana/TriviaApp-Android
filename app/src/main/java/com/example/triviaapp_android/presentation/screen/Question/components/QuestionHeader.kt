package com.example.triviaapp_android.presentation.screen.Question.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp_android.R

@Composable
fun QuestionHeader(){
    Image(
        painter = painterResource(id = R.drawable.questionwavetop),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )

    Text(
        text = "What caused the titular mascot of Yo-Kai Watch, Jibanyan, to become a yokai?",
        color = Color.White,
        fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 64.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Medium
    )
}