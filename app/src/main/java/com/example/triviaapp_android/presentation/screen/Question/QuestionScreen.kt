package com.example.triviaapp_android.presentation.screen.Question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.triviaapp_android.presentation.screen.Question.components.QuestionForm
import com.example.triviaapp_android.presentation.screen.Question.components.QuestionHeader
import com.example.triviaapp_android.presentation.screen.Question.components.questionGradient
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@Composable
fun QuestionScreen(navController: NavHostController, triviaViewModel: TriviaViewModel) {
    val questionUIState = triviaViewModel.questionUiState.collectAsState()

    LaunchedEffect(key1 = questionUIState.value.finished){
        if(questionUIState.value.finished){
            navController.navigate("result")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(questionGradient()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        QuestionHeader(questionUIState.value.question)

        QuestionForm(questionUIState.value.options, triviaViewModel)
    }
}

