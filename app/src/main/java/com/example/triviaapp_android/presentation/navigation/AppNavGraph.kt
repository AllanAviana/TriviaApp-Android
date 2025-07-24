package com.example.triviaapp_android.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
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

    // ViewModels
    val triviaViewModel: TriviaViewModel = viewModel()
    val authViewModel: AuthViewModel = hiltViewModel()

    // Current route to decide when to show the bottom bar
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Start destination (login)
    val start = if (authViewModel.isLoggedIn) "home" else "welcome"

    // Transitions
    val animSpec = tween<IntOffset>(300)

    fun AnimatedContentTransitionScope<NavBackStackEntry>.pushIn() =
        slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animSpec)
    fun AnimatedContentTransitionScope<NavBackStackEntry>.pushOut() =
        slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animSpec)
    fun AnimatedContentTransitionScope<NavBackStackEntry>.popIn() =
        slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, animSpec)
    fun AnimatedContentTransitionScope<NavBackStackEntry>.popOut() =
        slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, animSpec)

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

            // WELCOME
            composable(
                "welcome",
                enterTransition = { pushIn() },
                exitTransition = { pushOut() },
                popEnterTransition = { popIn() },
                popExitTransition = { popOut() }
            ) {
                WelcomeScreen(navController)
            }

            // LOGIN
            composable(
                "login",
                enterTransition = { pushIn() },
                exitTransition = { pushOut() },
                popEnterTransition = { popIn() },
                popExitTransition = { popOut() }
            ) {
                LoginScreen(navController, authViewModel, triviaViewModel)
            }

            // REGISTER
            composable(
                "register",
                enterTransition = { pushIn() },
                exitTransition = { pushOut() },
                popEnterTransition = { popIn() },
                popExitTransition = { popOut() }
            ) {
                RegisterScreen(navController, authViewModel, triviaViewModel)
            }

            // HOME
            composable(
                "home",
                enterTransition = {
                    if (initialState.destination.route == "progress") popIn() else pushIn()
                },
                exitTransition = {
                    if (targetState.destination.route == "progress") pushOut() else pushOut()
                },
                popEnterTransition = { popIn() },
                popExitTransition = { popOut() }
            ) {
                HomeScreen(navController, triviaViewModel, authViewModel)
            }

            // PROGRESS
            composable(
                "progress",
                enterTransition = { pushIn() },
                exitTransition = {
                    if (targetState.destination.route == "home") popOut() else pushOut()
                },
                popEnterTransition = { popIn() },
                popExitTransition = { popOut() }
            ) {
                ProgressScreen(triviaViewModel)
            }

            // DIFFICULTY
            composable(
                "difficulty",
                enterTransition = { pushIn() },
                exitTransition = { pushOut() },
                popEnterTransition = { popIn() },
                popExitTransition = { popOut() }
            ) {
                DifficultySelectionScreen(navController, triviaViewModel)
            }

            // QUESTION
            composable(
                "question",
                enterTransition = { pushIn() },
                exitTransition = { pushOut() },
                popEnterTransition = { popIn() },
                popExitTransition = { popOut() }
            ) {
                QuestionScreen(navController, triviaViewModel)
            }

            // RESULT
            composable(
                "result",
                enterTransition = { pushIn() },
                exitTransition = { pushOut() },
                popEnterTransition = { popIn() },
                popExitTransition = { popOut() }
            ) {
                ResultScreen(navController, triviaViewModel)
            }
        }
    }
}
