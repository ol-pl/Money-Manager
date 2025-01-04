package com.olpl.core_presentation.theme.colors

import androidx.compose.ui.graphics.Color

internal sealed class ColorPalettes(val color: Color) {

    sealed interface P1 {
        sealed interface Light {
            data object Primary : ColorPalettes(P1_PaleMist_Light)
            data object Secondary : ColorPalettes(P1_CloudyMist_Light)
            data object OnSecondary : ColorPalettes(P1_SoftAqua_Light)
            data object OnPrimary : ColorPalettes(P1_CalmTeal_Light)
            data object Tertiary : ColorPalettes(P1_PaleMist_Light)
            data object OnTertiary : ColorPalettes(P1_CalmTeal_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P1_MidnightCharcoal_Dark)
            data object Secondary : ColorPalettes(P1_SlateCharcoal_Dark)
            data object OnSecondary : ColorPalettes(P1_VibrantTeal_Dark)
            data object OnPrimary : ColorPalettes(P1_SoftWhite_Dark)
            data object Tertiary : ColorPalettes(P1_MidnightCharcoal_Dark)
            data object OnTertiary : ColorPalettes(P1_SoftWhite_Dark)
        }
    }

    sealed interface P2 {
        sealed interface Light {
            data object Primary : ColorPalettes(P2_IvoryFroth_Light)
            data object Secondary : ColorPalettes(P2_BurntSugar_Light)
            data object OnSecondary : ColorPalettes(P2_ToastedAlmond_Light)
            data object OnPrimary : ColorPalettes(P2_RoastedBean_Light)
            data object Tertiary : ColorPalettes(P2_IvoryFroth_Light)
            data object OnTertiary : ColorPalettes(P2_RoastedBean_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P2_SpicedCaramel_Dark)
            data object Secondary : ColorPalettes(P2_DarkMocha_Dark)
            data object OnSecondary : ColorPalettes(P2_EbonyCocoa_Dark)
            data object OnPrimary : ColorPalettes(P2_CreamBisque_Dark)
            data object Tertiary : ColorPalettes(P2_SpicedCaramel_Dark)
            data object OnTertiary : ColorPalettes(P2_CreamBisque_Dark)
        }
    }

    sealed interface P3 {
        sealed interface Light {
            data object Primary : ColorPalettes(P3_FreshSage_Light)
            data object Secondary : ColorPalettes(P3_SpringGreen_Light)
            data object OnSecondary : ColorPalettes(P3_SoftMint_Light)
            data object OnPrimary : ColorPalettes(P3_MorningMist_Light)
            data object Tertiary : ColorPalettes(P3_FreshSage_Light)
            data object OnTertiary : ColorPalettes(P3_MorningMist_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P3_EbonySage_Dark)
            data object Secondary : ColorPalettes(P3_MossGreen_Dark)
            data object OnSecondary : ColorPalettes(P3_IvoryTint_Dark)
            data object OnPrimary : ColorPalettes(P3_ClayTaupe_Dark)
            data object Tertiary : ColorPalettes(P3_EbonySage_Dark)
            data object OnTertiary : ColorPalettes(P3_ClayTaupe_Dark)
        }
    }

    sealed interface P4 {
        sealed interface Light {
            data object Primary : ColorPalettes(P4_DuskLavender_Light)
            data object Secondary : ColorPalettes(P4_MorningLilac_Light)
            data object OnSecondary : ColorPalettes(P4_FairyWisp_Light)
            data object OnPrimary : ColorPalettes(P4_BlushCloud_Light)
            data object Tertiary : ColorPalettes(P4_DuskLavender_Light)
            data object OnTertiary : ColorPalettes(P4_BlushCloud_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P4_TwilightLavender_Dark)
            data object Secondary : ColorPalettes(P4_LilacHaze_Dark)
            data object OnSecondary : ColorPalettes(P4_MoonlightMist_Dark)
            data object OnPrimary : ColorPalettes(P4_SoftPeach_Dark)
            data object Tertiary : ColorPalettes(P4_TwilightLavender_Dark)
            data object OnTertiary : ColorPalettes(P4_SoftPeach_Dark)
        }
    }

    sealed interface P5 {
        sealed interface Light {
            data object Primary : ColorPalettes(P5_PetalPink_Light)
            data object Secondary : ColorPalettes(P5_FadedRose_Light)
            data object OnSecondary : ColorPalettes(P5_OrchidBloom_Light)
            data object OnPrimary : ColorPalettes(P5_LavenderVale_Light)
            data object Tertiary : ColorPalettes(P5_PetalPink_Light)
            data object OnTertiary : ColorPalettes(P5_LavenderVale_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P5_DuskLilac_Dark)
            data object Secondary : ColorPalettes(P5_MidnightPlum_Dark)
            data object OnSecondary : ColorPalettes(P5_DarkOrchid_Dark)
            data object OnPrimary : ColorPalettes(P5_MoonlitViolet_Dark)
            data object Tertiary : ColorPalettes(P5_DuskLilac_Dark)
            data object OnTertiary : ColorPalettes(P5_MoonlitViolet_Dark)
        }
    }

    sealed interface P6 {
        sealed interface Light {
            data object Primary : ColorPalettes(P6_IvoryGlow_Light)
            data object Secondary : ColorPalettes(P6_SoftPeach_Light)
            data object OnSecondary : ColorPalettes(P6_CoralBlush_Light)
            data object OnPrimary : ColorPalettes(P6_EmberRed_Light)
            data object Tertiary : ColorPalettes(P6_IvoryGlow_Light)
            data object OnTertiary : ColorPalettes(P6_EmberRed_Light)
        }

        sealed interface Dark {
            data object Primary : ColorPalettes(P6_Ebony_Dark)
            data object Secondary : ColorPalettes(P6_Redwood_Dark)
            data object OnSecondary : ColorPalettes(P6_Ember_Dark)
            data object OnPrimary : ColorPalettes(P6_Spice_Dark)
            data object Tertiary : ColorPalettes(P6_Ebony_Dark)
            data object OnTertiary : ColorPalettes(P6_Spice_Dark)
        }
    }
}