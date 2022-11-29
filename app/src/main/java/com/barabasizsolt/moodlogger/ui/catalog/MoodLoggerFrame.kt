package com.barabasizsolt.moodlogger.ui.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MoodLoggerFrame(
    radius: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val density = LocalDensity.current
    val circleColor = MaterialTheme.colors.primary

    CircularLayout(
        radius = radius,
        startAngle = 120.0,
        content = content,
        modifier = modifier.drawBehind {
            drawCircle(
                color = circleColor,
                style = Stroke(width = 10f),
                radius = (with(density) { radius.roundToPx() }).toFloat()
            )
        }
    )
}

@Composable
fun MoodLoggerFrameItems(
    onClick: (position: Int) -> Unit,
    currentSelectedMoodPosition: Int,
    moodNumber: Int
) {
    val selectedMoodPosition = rememberSaveable { mutableStateOf(value = currentSelectedMoodPosition) }

    for (moodPosition in 0 until moodNumber) {
        if (selectedMoodPosition.value == moodPosition) {
            MoodToggleButton()
        } else {
            MoodFrameButton(
                onClick = {
                    onClick(moodPosition)
                    selectedMoodPosition.value = moodPosition
                }
            )
        }
    }
}

@Composable
private fun MoodToggleButton(
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
        .size(size = 40.dp)
        .clip(shape = MaterialTheme.shapes.medium)
        .background(color = MaterialTheme.colors.secondary)
) {
    Box(
        modifier = Modifier
            .size(size = 15.dp)
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colors.primaryVariant)
            .align(alignment = Alignment.Center)
    )
}

@Composable
private fun MoodFrameButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
        .clickable { onClick() }
        .size(size = 12.dp)
        .clip(shape = CircleShape)
        .background(color = MaterialTheme.colors.primary)
)