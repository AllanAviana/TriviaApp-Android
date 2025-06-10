package com.example.triviaapp_android.presentation.screen.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.triviaapp_android.presentation.screen.result.components.resultGradient
import components.HeaderSection
import components.PointsSection
import components.ScoreSection

@Composable
fun ResultScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(resultGradient()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderSection()

        ScoreSection()

        PointsSection()
    }
}