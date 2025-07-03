package com.example.triviaapp_android.presentation.screen.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.triviaapp_android.presentation.screen.register.components.RegisterForm
import com.example.triviaapp_android.presentation.screen.register.components.RegisterHeader
import com.example.triviaapp_android.presentation.viewmodel.AuthViewModel
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@Composable
fun RegisterScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    triviaViewModel: TriviaViewModel
) {
    val state by authViewModel.ui.collectAsState()


    LaunchedEffect(state.success) {
        if (state.success) {
            navController.navigate("login") {
                popUpTo("register") { inclusive = true }
            }
            authViewModel.clearSuccess()
            triviaViewModel.loadStats()
            triviaViewModel.loadLastPlayed()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegisterHeader()
        RegisterForm(authViewModel, state)
    }
}
