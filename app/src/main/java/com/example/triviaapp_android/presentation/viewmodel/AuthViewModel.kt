package com.example.triviaapp_android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp_android.firebase.AuthRepository
import com.example.triviaapp_android.presentation.UIStates.login.LoginUIState
import com.example.triviaapp_android.presentation.UIStates.registerUIState.RegisterUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {

    private val _ui = MutableStateFlow(RegisterUIState())
    val ui = _ui.asStateFlow()

    private val _loginUI = MutableStateFlow(LoginUIState())
    val loginUI = _loginUI.asStateFlow()

    fun onLoginEmail(v: String)    { _loginUI.update { it.copy(email = v) } }
    fun onLoginPass(v: String)     { _loginUI.update { it.copy(password = v) } }
    fun onEmailChange(v: String) { _ui.update { it.copy(email = v) }}
    fun onPassChange(v: String)     { _ui.update { it.copy(password = v) } }
    fun onConfirmChange(v: String)  { _ui.update { it.copy(confirm = v) } }

    fun register() {
        if (_ui.value.password != _ui.value.confirm) {
            _ui.update { it.copy(error = "Passwords don't match") }
            return
        }
        viewModelScope.launch {
            _ui.update { it.copy(loading = true, error = null) }
            val result = repo.register(_ui.value.email, _ui.value.password)
            result.fold(
                onSuccess = {
                    _ui.update { it.copy(loading = false, success = true) }
                },
                onFailure = { e ->
                    _ui.update { it.copy(loading = false, error = e.message) }
                }
            )
        }
    }

    fun clearSuccess() {
        _ui.update { it.copy(success = false) }
    }

    fun login() {
        viewModelScope.launch {
            _loginUI.update { it.copy(loading = true, error = null) }
            val result = repo.login(_loginUI.value.email, _loginUI.value.password)
            result.fold(
                onSuccess = { _loginUI.update { it.copy(loading = false, success = true) } },
                onFailure = { e -> _loginUI.update { it.copy(loading = false, error = e.message) } }
            )
        }
    }

    fun clearLoginSuccess() { _loginUI.update { it.copy(success = false) } }

    val isLoggedIn: Boolean get() = repo.isUserLoggedIn()

    fun logout() = repo.signOut()
}
