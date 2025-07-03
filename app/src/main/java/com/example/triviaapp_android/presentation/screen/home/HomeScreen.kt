package com.example.triviaapp_android.presentation.screen.home

import HomeForm
import HomeHeader
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.triviaapp_android.presentation.viewmodel.AuthViewModel
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    triviaViewModel: TriviaViewModel,
    authViewModel: AuthViewModel
) {
    val homeUIState = triviaViewModel.homeUIState.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        item {
            HomeHeader(homeUIState.value, navController) { authViewModel.logout() }
        }

        item {
            HomeForm(homeUIState.value, { navController.navigate("difficulty") }, triviaViewModel)
        }
    }
}