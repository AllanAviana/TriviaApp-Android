package com.example.triviaapp_android.presentation.screen.welcome.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text

@Composable
fun WelcomeTitle() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to", fontSize = 20.sp, color = Color.White)
        Text(
            "TriviaApp",
            fontSize = 40.sp,
            color = Color(0xFF005C8E),
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            "Login or create a new account",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}