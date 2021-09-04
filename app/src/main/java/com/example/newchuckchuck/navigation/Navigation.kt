package com.example.newchuckchuck.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.newchuckchuck.screens.Image.ImageScreen
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
            HomeScreen(navController = navHostController)
        }
        composable("list") {
            ListScreen(navController = navHostController)
        }
        composable(
            "note/{noteId}",
            arguments = listOf(
                navArgument("noteId") {
                    type = NavType.IntType
                }
            )
        ) { backstackEntry ->
            NoteScreen(
                noteId = backstackEntry.arguments?.getInt("noteId"),
                navigateToImageScreen = { fileName -> navHostController.navigate("img/$fileName") },
                navController = navHostController
            )
        }
        composable(
            "img/{fileName}",
            arguments = listOf(
                navArgument("fileName") {
                    type = NavType.StringType
                }
            )
        ) { backstackEntry ->
            backstackEntry.arguments?.getString("fileName")?.let {
                ImageScreen(
                    fileName = it,
                    popBackStack = { navHostController.popBackStack() }
                )
            }

        }
        composable("settings") {
            SettingsScreen(navController = navHostController)
        }
    }
}



