package com.example.newchuckchuck.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newchuckchuck.screens.home.HomeScreen
import com.example.newchuckchuck.screens.home.ListScreen
import com.example.newchuckchuck.screens.settings.SettingsScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("list") {
            ListScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}