package com.example.triviaapp_android.presentation.screen.difficultyselection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.triviaapp_android.presentation.screen.difficultyselection.components.DifficultySelectionGradient
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@Composable
fun DifficultySelectionScreen(navController: NavHostController, triviaViewModel: TriviaViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DifficultySelectionGradient())
            .padding(top = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {
            Text(
                text = "Choose the\ndifficulty level",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 40.sp
            )
        }

        Button(
            onClick = {
                navController.navigate("question")
                triviaViewModel.updateDifficulty("easy")
                triviaViewModel.getQuestions()
            },
            modifier = Modifier
                .padding(top = 100.dp)
                .fillMaxWidth(0.8f)
                .height(53.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(32.dp)
                ),
            colors = ButtonDefaults.buttonColors(Color(0xFF003155))
        ) {
            Text(
                text = "Easy",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Button(
            onClick = {
                navController.navigate("question")
                triviaViewModel.updateDifficulty("medium")
                triviaViewModel.getQuestions()
            },
            modifier = Modifier
                .padding(top = 72.dp)
                .fillMaxWidth(0.8f)
                .height(53.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(32.dp)
                ),
            colors = ButtonDefaults.buttonColors(Color(0xFF003155))
        ) {
            Text(
                text = "Medium",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Button(
            onClick = {
                navController.navigate("question")
                triviaViewModel.updateDifficulty("hard")
                triviaViewModel.getQuestions()
            },
            modifier = Modifier
                .padding(top = 72.dp)
                .fillMaxWidth(0.8f)
                .height(53.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(32.dp)
                ),
            colors = ButtonDefaults.buttonColors(Color(0xFF003155))
        ) {
            Text(
                text = "Hard",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
