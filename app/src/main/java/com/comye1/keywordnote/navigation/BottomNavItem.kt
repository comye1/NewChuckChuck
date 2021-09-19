package com.comye1.keywordnote.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        name = "Home",
        route = "home",
        icon = Icons.Default.Home
    )

    object List : BottomNavItem(
        name = "List",
        route = "list",
        icon = Icons.Default.List
    )

    object Settings : BottomNavItem(
        name = "Settings",
        route = "settings",
        icon = Icons.Default.Settings
    )
}