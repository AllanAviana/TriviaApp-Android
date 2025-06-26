package com.example.triviaapp_android.presentation.UIStates.registerUIState

data class RegisterUIState(
    val email: String = "",
    val password: String = "",
    val confirm: String = "",
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)

