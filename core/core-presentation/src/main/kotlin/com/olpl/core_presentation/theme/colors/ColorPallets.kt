package com.olpl.core_presentation.theme.colors

import androidx.compose.ui.graphics.Color

internal sealed class ColorPalettes(val color: Color) {
    sealed interface P1 {
        sealed interface Light {
            data object Primary : ColorPalettes(P1_DarkGreenGray_Light)
            data object Secondary : ColorPalettes(P1_LightGreenGray_Light)
            data object SubText : ColorPalettes(P1_SoftGray_Light)
            data object Text : ColorPalettes(P1_OffWhite_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P1_DarkGreenGray_Dark)
            data object Secondary : ColorPalettes(P1_LightGreenGray_Dark)
            data object SubText : ColorPalettes(P1_SoftGray_Dark)
            data object Text : ColorPalettes(P1_OffWhite_Dark)
        }
    }

    sealed interface P2 {
        sealed interface Light {
            data object Primary : ColorPalettes(P2_DarkIndigo_Light)
            data object Secondary : ColorPalettes(P2_DeepPurpleGray_Light)
            data object SubText : ColorPalettes(P2_CoolGray_Light)
            data object Text : ColorPalettes(P2_LightGray_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P2_DarkIndigo_Dark)
            data object Secondary : ColorPalettes(P2_DeepPurpleGray_Dark)
            data object SubText : ColorPalettes(P2_CoolGray_Dark)
            data object Text : ColorPalettes(P2_LightGray_Dark)
        }
    }
}