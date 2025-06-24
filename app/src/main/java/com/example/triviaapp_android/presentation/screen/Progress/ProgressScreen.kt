package com.example.triviaapp_android.presentation.screen.Progress

import ProgressHeader
import StatsCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@Composable
fun ProgressScreen(triviaViewModel: TriviaViewModel) {
    val uiState = triviaViewModel.progressUIState.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(
            bottom = 90.dp
        )
    ) {
        item {
            ProgressHeader(
                uiState.value.points,
                uiState.value.progress,
                uiState.value.total,
                uiState.value.medal
            )
        }
        items(uiState.value.cardList) { card ->
            StatsCard(card)
        }
    }

}


