package com.example.triviaapp_android.presentation.screen.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.fillMaxWidth
import com.example.triviaapp_android.R

@Composable
fun WelcomeHeaderImage() {
    Image(
        painter = painterResource(id = R.drawable.welcomeheaderimage),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth()
    )
}