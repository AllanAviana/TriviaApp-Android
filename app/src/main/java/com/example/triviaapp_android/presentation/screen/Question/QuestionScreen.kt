package com.example.triviaapp_android.presentation.screen.Question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.triviaapp_android.presentation.screen.Question.components.QuestionForm
import com.example.triviaapp_android.presentation.screen.Question.components.QuestionHeader
import com.example.triviaapp_android.presentation.screen.Question.components.questionGradient

@Composable
fun QuestionScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(questionGradient()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        QuestionHeader()

        Spacer(modifier = Modifier.height(54.dp))

        QuestionForm()
    }
}

