package com.example.androidpracticumcustomview.screen3

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun ThirdScreenContent(modifier: Modifier = Modifier) {
    CustomContainer(modifier) {
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Red)
        )
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Blue)
        )
    }
}


@Composable
fun CustomContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    var isAnimationStarted by remember { mutableStateOf(false) }

    val alpha by animateFloatAsState(
        targetValue = if (isAnimationStarted) 1f else 0f,
        animationSpec = tween(2000), label = ""
    )
    val transitionYFirst by animateFloatAsState(
        targetValue = if (isAnimationStarted) 0f else 1f,
        animationSpec = tween(5000), label = ""
    )
    val transitionYSecond by animateFloatAsState(
        targetValue = if (isAnimationStarted) 1f else 0f,
        animationSpec = tween(5000), label = ""
    )
    LaunchedEffect(Unit) { isAnimationStarted = true }

    Layout(
        content,
        modifier = modifier
    ) { measurables, constraints ->
        if (measurables.size > 2) {
            throw IllegalStateException("This container can contains only 2 composable or less")
        }
        val placeables = measurables.map {
            it.measure(constraints)
        }

        val height = constraints.maxHeight
        val width = constraints.maxWidth



        layout(width, height) {

            val startX = width / 2
            val startY = height / 2

            for (i in placeables.indices) {
                when (i) {
                    0 -> {
                        val place = IntOffset(
                            startX - placeables[i].width / 2,
                            ((startY - placeables[i].height) * transitionYFirst).toInt()
                        )
                        placeables[i].placeWithLayer(place) {
                            this.alpha = alpha
                        }
                    }

                    1 -> {
                        val place = IntOffset(
                            startX - placeables[i].width / 2,
                            (startY + (startY - placeables[i].height) * transitionYSecond).toInt()
                        )
                        placeables[i].placeWithLayer(place) {
                            this.alpha = alpha
                        }
                    }
                }
            }
        }

    }


}