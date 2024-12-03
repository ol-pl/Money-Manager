package com.olpl.core_presentation.providers

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Elevations(
    val default: Dp = 0.dp,
    val extraSmall: Dp = 2.5.dp,
    val small: Dp = 5.dp,
    val medium: Dp = 10.dp,
    val large: Dp = 20.dp,
    val extraLarge: Dp = 30.dp
)

val LocalElevations = staticCompositionLocalOf { Elevations() }
