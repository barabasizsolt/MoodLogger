package com.barabasizsolt.moodlogger.ui.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.barabasizsolt.moodlogger.R

@Composable
fun MoodLoggerArrows(
    radius: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) = CircularLayout(
    radius = radius / 2 + radius / 10,
    startAngle = 40.0,
    content = content,
    modifier = modifier
)

@Composable
fun MoodLoggerArrowItems(radius: Dp) {
    arrayListOf(R.drawable.arrow3, R.drawable.arrow4, R.drawable.arrow1, R.drawable.arrow2).forEach { id ->
        Image(
            painter = painterResource(id = id),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(size = radius / 3)
        )
    }
}