package com.olpl.core_presentation.theme.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import com.olpl.core_presentation.R

private val NotoSansJavaneseFont = Font(
    resId = R.font.noto_sans_javanese,
    loadingStrategy = FontLoadingStrategy.Async
)

internal val NotoSansJavaneseFontFamily = FontFamily(NotoSansJavaneseFont)
