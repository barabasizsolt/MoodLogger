package com.barabasizsolt.moodlogger.ui.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.barabasizsolt.moodlogger.data.Mood
import com.barabasizsolt.moodlogger.ui.theme.MoodLoggerTheme
import com.barabasizsolt.moodlogger.ui.util.getHeaderTextStyle

@Composable
fun MoodLogger(
    modifier: Modifier = Modifier,
    radius: Dp
) {
    val selectedMood = rememberSaveable { mutableStateOf(value = moods[8]) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MoodLoggerTitle(
            title = selectedMood.value.name,
            radius = radius
        )

        MoodLoggerBody(
            mood = selectedMood.value,
            onMoodChange = { mood -> selectedMood.value = mood },
            radius = radius
        )
    }
}

@Composable
private fun MoodLoggerTitle(title: String, radius: Dp) = Text(
    text = title,
    style = radius.getHeaderTextStyle(),
    color = MaterialTheme.colors.secondary,
    fontWeight = FontWeight.Bold
)

@Composable
private fun MoodLoggerBody(
    modifier: Modifier = Modifier,
    mood: Mood,
    onMoodChange: (mood: Mood) -> Unit,
    radius: Dp
) = Box(modifier = modifier) {
    MoodLoggerFrame(
        content = {
            MoodLoggerFrameItems(
                currentSelectedMoodPosition = moods.indexOf(element = mood),
                onClick = { position -> onMoodChange(moods[position]) },
                moodNumber = moods.size
            )
        },
        radius = radius,
        modifier = Modifier.align(alignment = Alignment.Center)
    )

    MoodLoggerArrows(
        content = { MoodLoggerArrowItems(radius = radius) },
        radius = radius,
        modifier = Modifier.align(alignment = Alignment.Center)
    )

    MoodLoggerFeelings(
        radius = radius,
        modifier = Modifier.align(alignment = Alignment.Center)
    )

    MoodEmoji(
        radius = radius,
        selectedMood = mood,
        modifier = Modifier.align(alignment = Alignment.Center)
    )
}

@Preview
@Composable
fun MoodLoggerPreview() = Box {
    MoodLoggerTheme(darkTheme = false) {
        MoodLogger(
            radius = LocalConfiguration.current.screenWidthDp.dp / 2 - 20.dp,
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}

private val moods = Mood.getMoods()

