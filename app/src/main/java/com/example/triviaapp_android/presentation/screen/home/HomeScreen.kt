package com.example.triviaapp_android.presentation.screen.home

import HomeForm
import HomeHeader
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        item{
            HomeHeader()
        }

        item {
            HomeForm()
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController)
}