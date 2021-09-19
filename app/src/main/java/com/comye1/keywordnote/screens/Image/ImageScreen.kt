package com.comye1.keywordnote.screens.Image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.calculatePan
import androidx.compose.foundation.gestures.calculateZoom
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.comye1.keywordnote.R

@Composable
fun ImageScreen(fileName: String, popBackStack: () -> Boolean) {

    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }


    Scaffold(topBar = {
        TopAppBar(
            title = { },
            backgroundColor = Color.White,
            navigationIcon = {
                IconButton(onClick = { popBackStack() }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "navigateback"
                    )
                }
            },
            elevation = 0.dp
        )
    }) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.White)
                .pointerInput(Unit) {
                    forEachGesture {
                        awaitPointerEventScope {
                            awaitFirstDown()
                            do {
                                val event = awaitPointerEvent()
                                scale *= event.calculateZoom()
                                val offset = event.calculatePan()
                                offsetX += offset.x
                                offsetY += offset.y
                            } while (event.changes.any { it.pressed })
                        }
                    }
                }
        ) {
            // There are multiple methods available to load an image resource in Compose.
            // However, it would be advisable to use the painterResource method as it loads
            // an image resource asynchronously
            val imagepainter = painterResource(id = R.drawable.cat)
            // Image is a pre-defined composable that lays out and draws a given [ImageBitmap].
            // We use the graphicsLayer modifier to modify the scale & translation of the image.
            // This is read from the state properties that we created above.
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(
                        scaleX = scale,
                        scaleY = scale,
                        translationX = offsetX,
                        translationY = offsetY
                    ),
                painter = imagepainter,
                contentDescription = "Landscape Image"
            )

        }
    }
}
