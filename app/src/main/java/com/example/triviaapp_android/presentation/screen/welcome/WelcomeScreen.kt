package com.example.triviaapp_android.presentation.screen.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.triviaapp_android.presentation.screen.welcome.components.LoginButton
import com.example.triviaapp_android.presentation.screen.welcome.components.SignUpButton
import com.example.triviaapp_android.presentation.screen.welcome.components.WelcomeHeaderImage
import com.example.triviaapp_android.presentation.screen.welcome.components.WelcomeTitle
import com.example.triviaapp_android.presentation.screen.welcome.components.welcomeGradient

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(welcomeGradient())
    ) {
        WelcomeHeaderImage()
        WelcomeTitle()
        LoginButton(modifier = Modifier.align(Alignment.CenterHorizontally))
        SignUpButton(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

