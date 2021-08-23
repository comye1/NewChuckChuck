package com.example.newchuckchuck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.newchuckchuck.navigation.BottomNavItem
import com.example.newchuckchuck.navigation.BottomNavigationBar
import com.example.newchuckchuck.navigation.Navigation
import com.example.newchuckchuck.ui.theme.NewChuckChuckTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewChuckChuckTheme {
                window.statusBarColor = Color(0, 102, 51).toArgb()
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }
                ) {
                    Navigation(navHostController = navController)
                }
            }
        }
    }
}

