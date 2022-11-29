package com.barabasizsolt.moodlogger.ui.catalog

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun CircularLayout(
    radius: Dp,
    modifier: Modifier = Modifier,
    paddingFromRadius: Dp = 0.dp,
    startAngle: Double = 0.0,
    content: @Composable () -> Unit
) {
    val itemRadiusPx = with(LocalDensity.current) { (radius - paddingFromRadius).roundToPx() }
    var totalRadius: Int
    var maxChildDiameter = 0

    Layout(
        content = content,
        measurePolicy = { measurable, constraints ->

            val placeables = measurable.map { it.measure(constraints = constraints) }

            placeables.forEach {
                val h = it.height.toDouble()
                val w = it.width.toDouble()
                val diameter = sqrt(x = h * h + w * w)
                if (diameter > maxChildDiameter) maxChildDiameter = diameter.toInt()
            }

            totalRadius = itemRadiusPx + maxChildDiameter /2

            layout(width = totalRadius * 2, height = totalRadius * 2) {
                val step = PI * 2 / placeables.size
                var angle = startAngle
                placeables.forEach {
                    it.placeRelative(
                        x = totalRadius - it.width / 2 + (itemRadiusPx * cos(angle)).toInt(),
                        y = totalRadius - it.height / 2 + (itemRadiusPx * sin(angle)).toInt(),
                    )
                    angle += step
                }
            }
        },
        modifier = modifier
    )
}