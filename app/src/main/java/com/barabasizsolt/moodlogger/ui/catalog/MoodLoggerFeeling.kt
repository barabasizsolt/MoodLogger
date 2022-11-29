package com.barabasizsolt.moodlogger.ui.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    PositiveFeeling(modifier = Modifier.align(alignment = Alignment.TopCenter), radius = radius)
    NegativeFeeling(modifier = Modifier.align(alignment = Alignment.BottomCenter), radius = radius)
    ActiveFeeling(modifier = Modifier.align(alignment = Alignment.CenterEnd), radius = radius)
    InactiveFeeling(modifier = Modifier.align(alignment = Alignment.CenterStart), radius = radius)
}

@Composable
fun PositiveFeeling(
    radius: Dp,
    modifier: Modifier = Modifier
) = VerticalFeelingItem(
    modifier = modifier
) {
    FeelingText(text = stringResource(id = R.string.positive), radius = radius)
    VerticalDivider(height = radius / 3)
}

@Composable
fun NegativeFeeling(
    radius: Dp,
    modifier: Modifier = Modifier
) = VerticalFeelingItem(
    modifier = modifier
) {
    VerticalDivider(height = radius / 3)
    FeelingText(text = stringResource(id = R.string.negative), radius = radius)
}

@Composable
fun ActiveFeeling(
    radius: Dp,
    modifier: Modifier = Modifier
) = HorizontalFeelingItem(
    modifier = modifier
) {
    HorizontalDivider(width = radius / 8)
    FeelingText(text = stringResource(id = R.string.active), radius = radius)
}

@Composable
fun InactiveFeeling(
    radius: Dp,
    modifier: Modifier = Modifier
) = HorizontalFeelingItem(
    modifier = modifier
) {
    FeelingText(text = stringResource(id = R.string.inactive), radius = radius)
    HorizontalDivider(width = radius / 8)
}

@Composable
private fun VerticalFeelingItem(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) = Column(
    modifier = modifier.wrapContentSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(space = 4.dp),
    content = content
)

@Composable
private fun HorizontalFeelingItem(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) = Row(
    modifier = modifier.wrapContentSize(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(space = 4.dp),
    content = content
)

@Composable
private fun VerticalDivider(height: Dp) = Divider(
    color = MaterialTheme.colors.primary,
    modifier = Modifier
        .height(height = height)
        .width(width = 2.dp)
)

@Composable
private fun HorizontalDivider(width: Dp) = Divider(
    color = MaterialTheme.colors.primary,
    thickness = 2.dp,
    modifier = Modifier
        .width(width = width)
)

@Composable
private fun FeelingText(
    radius: Dp,
    text: String
) = Text(
    text = text,
    maxLines = 1,
    color = MaterialTheme.colors.primary,
    style = radius.getTextStyle()
)