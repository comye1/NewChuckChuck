package com.comye1.keywordnote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.comye1.keywordnote.screens.Image.ImageScreen
import com.comye1.keywordnote.screens.NoteScreen
import com.comye1.keywordnote.screens.home.HomeScreen
import com.comye1.keywordnote.screens.home.ListScreen
import com.comye1.keywordnote.screens.settings.SettingsScreen
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



