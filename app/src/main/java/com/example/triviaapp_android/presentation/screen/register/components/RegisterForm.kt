package com.example.triviaapp_android.presentation.screen.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.triviaapp_android.R
import com.example.triviaapp_android.presentation.screen.welcome.components.LoginButton
import components.LoginTextField

@Composable
fun RegisterForm() {
    LoginTextField(
        label = "Create an user name",
        placeholder = "User name",
        value = "",
        onValueChange = {},
        modifier = Modifier.padding(top = 40.dp)
    )

    LoginTextField(
        label = "Create a password",
        placeholder = "Password",
        value = "",
        onValueChange = {},
        modifier = Modifier.padding(top = 24.dp)
    )

    LoginTextField(
        label = "Confirm your password",
        placeholder = "Password",
        value = "",
        onValueChange = {},
        modifier = Modifier.padding(top = 24.dp)
    )

    LoginButton(
        onClick = {},
        color = Color(0xFF2CA7CE),
        colorText = Color.White,
        text = "Sign up",
        padding = 48.dp
    )

    Image(
        painter = painterResource(id = R.drawable.registerimagefooter),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 30.dp)
            .size(76.dp)
    )
}