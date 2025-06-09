package com.example.triviaapp_android.presentation.navigation

sealed class Routes(val route: String) {
    object Welcome : Routes("welcome")
    object Login : Routes("login")
    object Register : Routes("register")
    object Home : Routes("home")
    object Progress : Routes("progress")
    object Difficulty : Routes("difficulty")
    object Question : Routes("'question")
    object Result : Routes("result")
}