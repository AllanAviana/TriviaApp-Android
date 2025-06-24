package com.example.triviaapp_android.presentation.screen.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.triviaapp_android.presentation.screen.result.components.resultGradient
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel
import components.HeaderSection
import components.PointsSection
import components.ScoreSection

@Composable
fun ResultScreen(navController: NavHostController, triviaViewModel: TriviaViewModel) {
    val resultUIState = triviaViewModel.resultUIState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(resultGradient()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderSection(resultUIState.value.image, resultUIState.value.text, resultUIState.value.word)

        ScoreSection(resultUIState.value.score)

        PointsSection(
            resultUIState.value.points,
            resultUIState.value.category,
            triviaViewModel
        ) { navController.navigate("home") }
    }
}