package com.olpl.core_presentation.theme.util

import android.util.Log
import com.olpl.core_presentation.R
import com.olpl.utils.StringId

sealed class FontFamilyVariants(
    val title: StringId,
    val type: FontLoadingStrategy,
    val id: Int
) {
    data object Roboto : FontFamilyVariants(
        R.string.roboto,
        FontLoadingStrategy.RUNTIME,
        1
    )

    data object NotoSansJavanese : FontFamilyVariants(
        R.string.noto_sans_javanese,
        FontLoadingStrategy.ASYNC,
        2
    )

    data object NotoSerifAhom : FontFamilyVariants(
        R.string.noto_serif_ahom,
        FontLoadingStrategy.ASYNC,
        3
    )

    data object Oswald : FontFamilyVariants(
        R.string.oswald,
        FontLoadingStrategy.ASYNC,
        4
    )

    data object PlayfairDisplay : FontFamilyVariants(
        R.string.playfair_display,
        FontLoadingStrategy.ASYNC,
        5
    )

    data object Poppins : FontFamilyVariants(
        R.string.poppins,
        FontLoadingStrategy.ASYNC,
        6
    )

    data object DancingScript : FontFamilyVariants(
        R.string.dancing_script,
        FontLoadingStrategy.ASYNC,
        7
    )

    data object YujiMain : FontFamilyVariants(
        R.string.yuji_main,
        FontLoadingStrategy.ASYNC,
        8
    )

    companion object {
        fun getById(id: Int): FontFamilyVariants = getAll().find { it.id == id }!!

        fun getAll(): List<FontFamilyVariants> = listOf(
            Roboto,
            NotoSansJavanese,
            NotoSerifAhom,
            Oswald,
            PlayfairDisplay,
            Poppins,
            DancingScript,
            YujiMain
        )
    }
}