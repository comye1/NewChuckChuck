package com.example.newchuckchuck

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.example.newchuckchuck.navigation.BottomNavigationBar
import com.example.newchuckchuck.navigation.Navigation
import com.example.newchuckchuck.ui.theme.DeepGreen
import com.example.newchuckchuck.ui.theme.NewChuckChuckTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import java.io.IOException

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewChuckChuckTheme {
                window.statusBarColor = DeepGreen.toArgb()
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) {
                    Navigation(navHostController = navController)
                }
            }
        }
//        val bmp = BitmapFactory.decodeResource(resources, R.drawable.cat)
//        savePhotoToInternalStorage("sampleImage", bmp)
        deletePhotoFromInternalStorage("sampleImage.jpg")
    }

    fun savePhotoToInternalStorage(filename: String, bmp: Bitmap): Boolean {
        return try {
            openFileOutput("$filename.jpg", MODE_PRIVATE).use { stream ->
                if (!bmp.compress(Bitmap.CompressFormat.JPEG, 95, stream)) {
                    throw IOException("Couldn't save bitmap.")
                }
            }
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    fun deletePhotoFromInternalStorage(filename: String): Boolean {
        return try {
            deleteFile(filename)
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
