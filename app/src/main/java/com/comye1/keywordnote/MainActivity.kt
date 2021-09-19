package com.comye1.keywordnote

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.comye1.keywordnote.navigation.BottomNavigationBar
import com.comye1.keywordnote.navigation.Navigation
import com.comye1.keywordnote.ui.theme.DeepGreen
import com.comye1.keywordnote.ui.theme.KeywordNoteTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import java.io.IOException

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KeywordNoteTheme() {
                window.statusBarColor = DeepGreen.toArgb()
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) {
                    Navigation(navHostController = navController)
                }
            }
        }
        val bmp = BitmapFactory.decodeResource(resources, R.drawable.cat)
        savePhotoToInternalStorage("sampleImage5", bmp)
//        deletePhotoFromInternalStorage("sampleImage.jpg")
    }

    fun savePhotoToInternalStorage(filename: String, bmp: Bitmap): Boolean {
        return try {
            openFileOutput("$filename.jpg", MODE_PRIVATE).use { stream ->
                if (!bmp.compress(Bitmap.CompressFormat.JPEG, 30, stream)) {
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
