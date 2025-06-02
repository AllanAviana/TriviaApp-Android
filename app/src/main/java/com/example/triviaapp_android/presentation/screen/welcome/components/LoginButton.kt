package com.example.triviaapp_android.presentation.screen.welcome.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun LoginButton(onClick: () -> Unit = {}, modifier: Modifier = Modifier, color: Color = Color.White, colorText: Color = Color(0xFF2CA7CE)) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(top = 72.dp)
            .width(318.dp)
            .height(53.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(50),
    ) {
        Text("Login", color = colorText)
    }
}