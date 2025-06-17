package com.example.triviaapp_android.presentation.screen.Question.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp_android.R
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@Composable
fun QuestionForm(options: List<String>, triviaViewModel: TriviaViewModel) {
    options.forEach { option ->
        Button(
            onClick = {
                triviaViewModel.checkAnswer(option)
                triviaViewModel.updateQuestionUIState()
            },
            modifier = Modifier
                .padding(top = 32.dp)
                .fillMaxWidth(0.9f)
                .height(64.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF003155))
        ) {
            Text(
                text = option,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.questionwavefooter),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.Crop
        )
    }
}