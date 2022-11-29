package com.barabasizsolt.moodlogger.ui.util

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dp.getTextStyle() = when {
    this > 300.dp -> MaterialTheme.typography.h5
    this > 200.dp -> MaterialTheme.typography.h6
    this > 100.dp -> MaterialTheme.typography.body1
    else -> MaterialTheme.typography.overline.copy(letterSpacing = 0.4.sp)
}

@Composable
fun Dp.getHeaderTextStyle() = when {
    this > 300.dp -> MaterialTheme.typography.h3
    this > 200.dp -> MaterialTheme.typography.h4
    this > 100.dp -> MaterialTheme.typography.h5
    else -> MaterialTheme.typography.h6
}