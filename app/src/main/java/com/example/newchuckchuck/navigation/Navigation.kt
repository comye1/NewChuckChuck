package com.example.newchuckchuck.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.newchuckchuck.screens.NoteScreen
import com.example.newchuckchuck.screens.home.HomeScreen
import com.example.newchuckchuck.screens.home.ListScreen
import com.example.newchuckchuck.screens.settings.SettingsScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("list") {
            ListScreen(navController = navHostController)
        }
        composable("note/{noteId}",
            arguments = listOf(
                navArgument("noteId") {
                    type = NavType.IntType
                }
            )) { backstackEntry ->
            NoteScreen(noteId = backstackEntry.arguments?.getInt("noteId"), navController = navHostController)
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}

