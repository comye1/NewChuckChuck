package com.example.newchuckchuck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.newchuckchuck.navigation.BottomNavigationBar
import com.example.newchuckchuck.ui.theme.DeepGreen
import com.example.newchuckchuck.ui.theme.NewChuckChuckTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewChuckChuckTheme {
                window.statusBarColor = DeepGreen.toArgb()
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }
                ) {
//                    Navigation(navHostController = navController)
                    ImagePager(count = 4)
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun ImagePager(count: Int) {
    val pagerState = rememberPagerState(pageCount = count)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(20.dp)
        )
        HorizontalPager(
            state = pagerState
        ) {

            var scale by remember {
                mutableStateOf(1f)
            }

//            Image(painterResource(id = R.drawable.cat), contentDescription = "")
            Image(
                painterResource(id = R.drawable.cat),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTransformGestures { _, _, zoom, _ ->
                            scale = when {
                                scale < 0.5f -> 0.5f
                                scale > 3f -> 3f
                                else -> scale * zoom
                            }
                        }
                    }
                    .graphicsLayer(
                        scaleX = scale,
                        scaleY = scale,
                    ),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun ZoomableImage() {


}