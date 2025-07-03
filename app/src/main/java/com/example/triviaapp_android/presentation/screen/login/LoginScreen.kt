package com.example.triviaapp_android.presentation.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.triviaapp_android.presentation.viewmodel.AuthViewModel
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel
import components.LoginForm
import components.LoginHeader
import components.loginGradient

@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    triviaViewModel: TriviaViewModel
) {

    val state by authViewModel.loginUI.collectAsState()
    LaunchedEffect(state.success) {
        if (state.success) {
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
            authViewModel.clearLoginSuccess()
            triviaViewModel.loadStats()
            triviaViewModel.loadLastPlayed()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(loginGradient())

    ) {
        LoginHeader()

        LoginForm(state, authViewModel, triviaViewModel)
    }
}