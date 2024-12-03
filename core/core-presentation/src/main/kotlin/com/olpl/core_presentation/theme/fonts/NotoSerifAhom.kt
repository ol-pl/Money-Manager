package com.olpl.core_presentation.theme.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import com.olpl.core_presentation.R

private val NotoSerifAhomFont = Font(
    resId = R.font.noto_serif_ahom,
    loadingStrategy = FontLoadingStrategy.Async
)

internal val NotoSerifAhomFontFamily = FontFamily(NotoSerifAhomFont)
