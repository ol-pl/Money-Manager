package com.olpl.core_presentation.theme.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import com.olpl.core_presentation.R

private val PoppinsFont = Font(
    resId = R.font.poppins,
    loadingStrategy = FontLoadingStrategy.Async
)

internal val PoppinsFontFamily = FontFamily(PoppinsFont)
