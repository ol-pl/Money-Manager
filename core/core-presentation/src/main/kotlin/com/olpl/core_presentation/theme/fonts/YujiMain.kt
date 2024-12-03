package com.olpl.core_presentation.theme.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import com.olpl.core_presentation.R

private val YujiMaiFont = Font(
    resId = R.font.yuji_mai,
    loadingStrategy = FontLoadingStrategy.Async
)

internal val YujiMaiFontFamily = FontFamily(YujiMaiFont)
