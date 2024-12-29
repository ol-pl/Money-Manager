package com.olpl.core_presentation.theme.util

import com.olpl.core_presentation.R
import com.olpl.utils.StringId

sealed class PaletteVariants(
    val title: StringId,
    val id: Int
) {
    data object P1 : PaletteVariants(R.string.palette_1, 1)
    data object P2 : PaletteVariants(R.string.palette_2, 2)
    data object P3 : PaletteVariants(R.string.palette_3, 3)

    companion object {
        fun getById(id: Int): PaletteVariants = getAll().find { it.id == id }!!

        fun getAll(): List<PaletteVariants> = listOf(
            P1,
            P2,
            P3
        )
    }
}
