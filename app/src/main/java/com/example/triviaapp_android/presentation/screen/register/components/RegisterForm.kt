package com.example.triviaapp_android.presentation.screen.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.triviaapp_android.R
import com.example.triviaapp_android.presentation.UIStates.registerUIState.RegisterUIState
import com.example.triviaapp_android.presentation.screen.welcome.components.LoginButton
import com.example.triviaapp_android.presentation.viewmodel.AuthViewModel
import components.LoginTextField

@Composable
fun RegisterForm(authViewModel: AuthViewModel, state: RegisterUIState) {

    LoginTextField(
        label = "E-mail",
        placeholder = "you@example.com",
        value = state.email,
        onValueChange = { authViewModel.onEmailChange(it) },   // ← lambda
        modifier = Modifier.padding(top = 40.dp)
    )
    LoginTextField(
        label = "Password",
        placeholder = "••••••••",
        value = state.password,
        onValueChange = authViewModel::onPassChange,
        modifier = Modifier.padding(top = 24.dp),
    )
    LoginTextField(
        label = "Confirm password",
        placeholder = "••••••••",
        value = state.confirm,
        onValueChange = authViewModel::onConfirmChange,
        modifier = Modifier.padding(top = 24.dp),
    )

    LoginButton(
        onClick = authViewModel::register,
        color = Color(0xFF2CA7CE),
        colorText = Color.White,
        text = if (state.loading) "Signing up…" else "Sign up",
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