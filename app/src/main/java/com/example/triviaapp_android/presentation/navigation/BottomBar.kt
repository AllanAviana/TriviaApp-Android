package com.example.triviaapp_android.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

val OuterBlue = Color(0xFF04A9FF)
val InnerBlue = Color(0xFFB9DFEB)

@Composable
fun BottomBar(navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Box(
        modifier = Modifier
            .padding(bottom = 36.dp)
            .fillMaxWidth()
            .height(56.dp),
        Alignment.Center

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)       // deixa laterais “vazadas”
                .fillMaxHeight()
                .align(Alignment.Center)
                .background(InnerBlue, RoundedCornerShape(12.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 48.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NavIcon(
                    selected = currentRoute == "home",
                    onClick = { navController.navigate("home") },
                    icon = Icons.Default.Home,
                    desc = "Home"
                )
                NavIcon(
                    selected = currentRoute == "progress",
                    onClick = { navController.navigate("progress") },
                    icon = Icons.Default.Person,
                    desc = "Progress"
                )
            }
        }
    }
}

@Composable
private fun NavIcon(
    selected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    desc: String
) {
    Icon(
        imageVector = icon,
        contentDescription = desc,
        tint = if (selected) OuterBlue else Color(0xFF0277A7), // mesmo tom do mock
        modifier = Modifier
            .size(28.dp)
            .clickable { onClick() }
    )
}

