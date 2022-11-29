package com.barabasizsolt.moodlogger.ui.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.barabasizsolt.moodlogger.R
import com.barabasizsolt.moodlogger.ui.util.getTextStyle

@Composable
fun MoodLoggerFeelings(
    radius: Dp,
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
        .height(height = radius * 2 - radius / 4)
        .width(width = radius * 2 - radius / 6)
) {
    FeelingText(
        text = stringResource(id = R.string.positive),
        radius = radius,
        modifier = Modifier.align(alignment = Alignment.TopCenter)
    )
    FeelingText(
        text = stringResource(id = R.string.negative),
        radius = radius,
        modifier = Modifier.align(alignment = Alignment.BottomCenter)
    )
    FeelingText(
        text = stringResource(id = R.string.active),
        radius = radius,
        modifier = Modifier.align(alignment = Alignment.CenterEnd)
    )
    FeelingText(
        text = stringResource(id = R.string.inactive),
        radius = radius,
        modifier = Modifier.align(alignment = Alignment.CenterStart)
    )

    VerticalDivider(
        height = radius + radius / 3,
        modifier = Modifier.align(alignment = Alignment.Center)
    )
    HorizontalDivider(
        width = radius + radius / 6,
        modifier = Modifier.align(alignment = Alignment.Center)
    )

    Box(
        modifier = Modifier
            .size(size = radius / 3 + radius / 2)
            .clip(shape = CircleShape)
            .background(color = MaterialTheme.colors.background)
            .align(alignment = Alignment.Center)
    )
}

@Composable
private fun VerticalDivider(
    height: Dp,
    modifier: Modifier = Modifier
) = Divider(
    color = MaterialTheme.colors.primary,
    modifier = modifier
        .height(height = height)
        .width(width = 2.dp)
)

@Composable
private fun HorizontalDivider(
    width: Dp,
    modifier: Modifier = Modifier
) = Divider(
    color = MaterialTheme.colors.primary,
    thickness = 2.dp,
    modifier = modifier.width(width = width)
)

@Composable
private fun FeelingText(
    radius: Dp,
    text: String,
    modifier: Modifier = Modifier
) = Text(
    text = text,
    maxLines = 1,
    color = MaterialTheme.colors.primary,
    style = radius.getTextStyle(),
    modifier = modifier
)