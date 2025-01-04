package com.olpl.core_presentation.theme.util

import androidx.compose.material3.ColorScheme
import com.olpl.core_presentation.R
import com.olpl.core_presentation.theme.colors.DarkSchemeP1
import com.olpl.core_presentation.theme.colors.DarkSchemeP2
import com.olpl.core_presentation.theme.colors.DarkSchemeP3
import com.olpl.core_presentation.theme.colors.DarkSchemeP4
import com.olpl.core_presentation.theme.colors.DarkSchemeP5
import com.olpl.core_presentation.theme.colors.DarkSchemeP6
import com.olpl.core_presentation.theme.colors.LightSchemeP1
import com.olpl.core_presentation.theme.colors.LightSchemeP2
import com.olpl.core_presentation.theme.colors.LightSchemeP3
import com.olpl.core_presentation.theme.colors.LightSchemeP4
import com.olpl.core_presentation.theme.colors.LightSchemeP5
import com.olpl.core_presentation.theme.colors.LightSchemeP6
import com.olpl.utils.StringId

sealed class PaletteVariants(
    val title: StringId,
    val id: Int,
    private val lightColorScheme: ColorScheme,
    private val darkColorScheme: ColorScheme
) {
    data object P1 : PaletteVariants(R.string.palette_1, 1, LightSchemeP1, DarkSchemeP1)
    data object P2 : PaletteVariants(R.string.palette_2, 2, LightSchemeP2, DarkSchemeP2)
    data object P3 : PaletteVariants(R.string.palette_3, 3, LightSchemeP3, DarkSchemeP3)
    data object P4 : PaletteVariants(R.string.palette_4, 4, LightSchemeP4, DarkSchemeP4)
    data object P5 : PaletteVariants(R.string.palette_5, 5, LightSchemeP5, DarkSchemeP5)
    data object P6 : PaletteVariants(R.string.palette_6, 6, LightSchemeP6, DarkSchemeP6)

    companion object {
        fun getById(id: Int): PaletteVariants = getAll().find { it.id == id }!!

        fun getAll(): List<PaletteVariants> = listOf(
            P1,
            P2,
            P3,
            P4,
            P5,
            P6
        )
    }

    fun getScheme(isDark: Boolean): ColorScheme {
        return if (isDark) darkColorScheme else lightColorScheme
    }
}
