package com.barabasizsolt.moodlogger.ui.catalog

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
import com.barabasizsolt.moodlogger.ui.util.getHeaderTextStyle

@Preview
@Composable
fun MoodLogger(
    modifier: Modifier = Modifier,
    radius: Dp = LocalConfiguration.current.screenWidthDp.dp / 2 - 20.dp
) {
    val selectedMood = rememberSaveable { mutableStateOf(value = moods[12]) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = selectedMood.value.name,
            style = radius.getHeaderTextStyle(),
            color = MaterialTheme.colors.secondary,
            fontWeight = FontWeight.Bold
        )

        Box {
            MoodLoggerFrame(
                content = {
                    MoodLoggerFrameItems(
                        currentSelectedMoodPosition = moods.indexOf(element = selectedMood.value),
                        onClick = { position -> selectedMood.value = moods[position] },
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

            Mood(
                radius = radius,
                selectedMood = selectedMood.value,
                modifier = Modifier.align(alignment = Alignment.Center)
            )
        }
    }
}

