package com.example.newchuckchuck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.example.newchuckchuck.navigation.Navigation
import com.example.newchuckchuck.ui.theme.DeepGreen
import com.example.newchuckchuck.ui.theme.NewChuckChuckTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewChuckChuckTheme {
                window.statusBarColor = DeepGreen.toArgb()
                val navController = rememberNavController()

                Navigation(navHostController = navController)

            }
        }
    }
}
