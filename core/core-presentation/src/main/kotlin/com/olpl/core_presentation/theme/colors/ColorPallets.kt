package com.olpl.core_presentation.theme.colors

import androidx.compose.ui.graphics.Color

internal sealed class ColorPalettes(val color: Color) {
    sealed interface P1 {
        sealed interface Light {
            data object Primary : ColorPalettes(P1_DarkGreenGray_Light)
            data object Secondary : ColorPalettes(P1_LightGreenGray_Light)
            data object OnSecondary : ColorPalettes(P1_SoftGray_Light)
            data object OnPrimary : ColorPalettes(P1_OffWhite_Light)
            data object Tertiary : ColorPalettes(P1_LightGreenGray_Light)
            data object OnTertiary : ColorPalettes(P1_DarkGreenGray_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P1_DarkGreenGray_Dark)
            data object Secondary : ColorPalettes(P1_LightGreenGray_Dark)
            data object OnSecondary : ColorPalettes(P1_SoftGray_Dark)
            data object OnPrimary : ColorPalettes(P1_OffWhite_Dark)
            data object Tertiary : ColorPalettes(P1_LightGreenGray_Dark)
            data object OnTertiary : ColorPalettes(P1_DarkGreenGray_Dark)
        }
    }

    sealed interface P2 {
        sealed interface Light {
            data object Primary : ColorPalettes(P2_DarkIndigo_Light)
            data object Secondary : ColorPalettes(P2_DeepPurpleGray_Light)
            data object OnSecondary : ColorPalettes(P2_CoolGray_Light)
            data object OnPrimary : ColorPalettes(P2_LightGray_Light)
            data object Tertiary : ColorPalettes(P2_DeepPurpleGray_Light)
            data object OnTertiary : ColorPalettes(P2_DarkIndigo_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P2_DarkIndigo_Dark)
            data object Secondary : ColorPalettes(P2_DeepPurpleGray_Dark)
            data object OnSecondary : ColorPalettes(P2_CoolGray_Dark)
            data object OnPrimary : ColorPalettes(P2_LightGray_Dark)
            data object Tertiary : ColorPalettes(P2_DeepPurpleGray_Dark)
            data object OnTertiary : ColorPalettes(P2_DarkIndigo_Dark)
        }
    }

    sealed interface P3 {
        sealed interface Light {
            data object Primary : ColorPalettes(P3_BlackGraphite_Light)
            data object Secondary : ColorPalettes(P3_DeepBlackGraphite_Light)
            data object OnSecondary : ColorPalettes(P3_CoolWhite_Light)
            data object OnPrimary : ColorPalettes(P3_GoldOre_Light)
            data object Tertiary : ColorPalettes(P3_DeepBlackGraphite_Light)
            data object OnTertiary : ColorPalettes(P3_GoldOre_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P3_BlackGraphite_Dark)
            data object Secondary : ColorPalettes(P3_DeepBlackGraphite_Dark)
            data object OnSecondary : ColorPalettes(P3_CoolWhite_Dark)
            data object OnPrimary : ColorPalettes(P3_GoldOre_Dark)
            data object Tertiary : ColorPalettes(P3_DeepBlackGraphite_Dark)
            data object OnTertiary : ColorPalettes(P3_GoldOre_Dark)
        }
    }
}