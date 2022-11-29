package com.barabasizsolt.moodlogger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.barabasizsolt.moodlogger.ui.catalog.MoodLogger
import com.barabasizsolt.moodlogger.ui.theme.MoodLoggerTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoodLoggerTheme(darkTheme = false) {
                val radius = LocalConfiguration.current.screenWidthDp.dp / 2 - 20.dp
                var rememberedRadius by rememberSaveable { mutableStateOf(value = radius.value) }

                Box(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.background)) {
                    MoodLogger(
                        radius = rememberedRadius.dp,
                        modifier = Modifier.align(alignment = Alignment.Center)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.BottomCenter),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Radius: $rememberedRadius")
                        Slider(
                            value = rememberedRadius,
                            onValueChange = { rememberedRadius = it },
                            valueRange = 50f..radius.value,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    }
                }
            }
        }
    }
}