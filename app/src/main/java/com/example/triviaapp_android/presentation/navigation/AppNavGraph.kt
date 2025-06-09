package com.example.triviaapp_android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.triviaapp_android.presentation.screen.Progress.ProgressScreen
import com.example.triviaapp_android.presentation.screen.Question.QuestionScreen
import com.example.triviaapp_android.presentation.screen.difficultyselection.DifficultySelectionScreen
import com.example.triviaapp_android.presentation.screen.home.HomeScreen
import com.example.triviaapp_android.presentation.screen.login.LoginScreen
import com.example.triviaapp_android.presentation.screen.register.RegisterScreen
import com.example.triviaapp_android.presentation.screen.result.ResultScreen
import com.example.triviaapp_android.presentation.screen.welcome.WelcomeScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("welcome"){
            WelcomeScreen(navController)
        }
        composable("login"){
            LoginScreen(navController)
        }

        composable("register"){
            RegisterScreen(navController)
        }

        composable("home"){
            HomeScreen(navController)
        }

        composable("progress"){
            ProgressScreen(navController)
        }

        composable("difficulty"){
            DifficultySelectionScreen(navController)
        }

        composable("question"){
            QuestionScreen(navController)
        }

        composable("result"){
            ResultScreen()
        }
    }
}