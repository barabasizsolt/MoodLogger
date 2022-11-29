package com.barabasizsolt.moodlogger.ui.catalog

import android.os.Parcelable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.barabasizsolt.moodlogger.R
import kotlinx.parcelize.Parcelize

@Composable
fun Mood(
    radius: Dp,
    selectedMood: Mood,
    modifier: Modifier = Modifier
) = Image(
    painter = painterResource(id = selectedMood.resId),
    contentDescription = null,
    contentScale = ContentScale.Fit,
    modifier = modifier.size(size = radius / 3 + radius / 2)
)

val moods = buildList {
    add(element = Mood(name = "Discouraged", resId = R.drawable.discouraged))
    add(element = Mood(name = "Bored", resId = R.drawable.bored))
    add(element = Mood(name = "Lonely", resId = R.drawable.lonely))
    add(element = Mood(name = "Sad", resId = R.drawable.sad))

    add(element = Mood(name = "Reserved", resId = R.drawable.reserved))
    add(element = Mood(name = "Quiet", resId = R.drawable.quiet))
    add(element = Mood(name = "Humble", resId = R.drawable.humble))
    add(element = Mood(name = "Relaxed", resId = R.drawable.relaxed))

    add(element = Mood(name = "Proud", resId = R.drawable.proud))
    add(element = Mood(name = "Happy", resId = R.drawable.happy))
    add(element = Mood(name = "Cooperative", resId = R.drawable.cooperative))
    add(element = Mood(name = "Excited", resId = R.drawable.excited))

    add(element = Mood(name = "Angry", resId = R.drawable.angry))
    add(element = Mood(name = "Frustrated", resId = R.drawable.frustrated))
    add(element = Mood(name = "Shamed", resId = R.drawable.shamed))
    add(element = Mood(name = "Fearful", resId = R.drawable.fearful))
}

@Parcelize
data class Mood(
    val name: String,
    val resId: Int
) : Parcelable