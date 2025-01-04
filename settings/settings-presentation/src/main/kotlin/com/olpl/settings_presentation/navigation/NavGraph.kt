package com.olpl.settings_presentation.navigation

import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.olpl.core_presentation.navigation.AppDestinations
import com.olpl.core_presentation.navigation.composableImpl
import com.olpl.core_presentation.navigation.dialogImpl
import com.olpl.core_presentation.providers.LocalCurrentNavigator
import com.olpl.core_presentation.providers.util.currentNotNull
import com.olpl.settings_presentation.navigation.util.SettingsDestinations
import com.olpl.settings_presentation.ui.SettingsScreenRoot
import com.olpl.settings_presentation.ui.dialog_screens.ColorModeDialog
import com.olpl.settings_presentation.ui.dialog_screens.ColorsDialog
import com.olpl.settings_presentation.ui.dialog_screens.FontFamilyVariantsDialog

fun NavGraphBuilder.settingsGraph() {
    composableImpl<AppDestinations.AccountGraph> {
        CompositionLocalProvider(
            LocalCurrentNavigator provides rememberNavController()
        ) {
            val currentNavController = LocalCurrentNavigator.currentNotNull()
            NavHost(
                navController = currentNavController,
                startDestination = SettingsDestinations.SettingsScreen
            ) {
                composableImpl<SettingsDestinations.SettingsScreen> {
                    SettingsScreenRoot()
                }
                dialogImpl<SettingsDestinations.ColorsDialog> {
                    ColorsDialog()
                }
                dialogImpl<SettingsDestinations.ColorModeDialog> {
                    ColorModeDialog()
                }
                dialogImpl<SettingsDestinations.FontFamilyVariantDialog> {
                    FontFamilyVariantsDialog()
                }
            }
        }
    }
}