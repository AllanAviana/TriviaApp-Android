package com.example.triviaapp_android.presentation.UIStates.login

data class LoginUIState(
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)
