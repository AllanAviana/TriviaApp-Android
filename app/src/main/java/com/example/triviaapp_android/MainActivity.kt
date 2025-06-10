package com.example.triviaapp_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.triviaapp_android.presentation.navigation.AppNavGraph
import com.example.triviaapp_android.presentation.screen.home.HomeScreen
import com.example.triviaapp_android.ui.theme.TriviaAppAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TriviaAppAndroidTheme {
                AppNavGraph()
            }
        }
    }
}
