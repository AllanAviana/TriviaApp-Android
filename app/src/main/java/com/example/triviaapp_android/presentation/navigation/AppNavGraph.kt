package com.example.triviaapp_android.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.triviaapp_android.presentation.screen.Progress.ProgressScreen
import com.example.triviaapp_android.presentation.screen.Question.QuestionScreen
import com.example.triviaapp_android.presentation.screen.difficultyselection.DifficultySelectionScreen
import com.example.triviaapp_android.presentation.screen.home.HomeScreen
import com.example.triviaapp_android.presentation.screen.login.LoginScreen
import com.example.triviaapp_android.presentation.screen.register.RegisterScreen
import com.example.triviaapp_android.presentation.screen.result.ResultScreen
import com.example.triviaapp_android.presentation.screen.welcome.WelcomeScreen
import com.example.triviaapp_android.presentation.viewmodel.AuthViewModel
import com.example.triviaapp_android.presentation.viewmodel.TriviaViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    val triviaViewModel: TriviaViewModel = viewModel()
    val authViewModel: AuthViewModel = hiltViewModel()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val start = if (authViewModel.isLoggedIn) "home" else "welcome"

    Scaffold(
        bottomBar = {
            if (currentRoute == "home" || currentRoute == "progress") {
                BottomBar(navController)
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = start,
            modifier = Modifier
        ) {
            composable("welcome") { WelcomeScreen(navController) }
            composable("login") { LoginScreen(navController, authViewModel) }
            composable("register") { RegisterScreen(navController, authViewModel) }
            composable("home") { HomeScreen(navController, triviaViewModel) }
            composable("progress") { ProgressScreen(triviaViewModel) }
            composable("difficulty") { DifficultySelectionScreen(navController, triviaViewModel) }
            composable("question") { QuestionScreen(navController, triviaViewModel) }
            composable("result") { ResultScreen(navController, triviaViewModel) }
        }
    }
}

