package com.barabasizsolt.moodlogger.ui.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.barabasizsolt.moodlogger.data.Mood

@Composable
fun MoodEmoji(
    radius: Dp,
    selectedMood: Mood,
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
        .size(size = radius / 3 + radius / 2)
        .clip(shape = CircleShape)
        .background(color = MaterialTheme.colors.background)
) {
    Image(
        painter = painterResource(id = selectedMood.resId),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(size = radius / 3 + radius / 2)
    )
}