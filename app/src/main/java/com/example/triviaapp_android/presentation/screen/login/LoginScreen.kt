package com.example.triviaapp_android.presentation.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import components.LoginForm
import components.LoginHeader
import components.loginGradient

@Composable
fun LoginScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(loginGradient())

    ) {
        LoginHeader()

        LoginForm()
    }
}