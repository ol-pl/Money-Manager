package com.olpl.settings_presentation.navigation

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.olpl.core_presentation.navigation.AppDestinations
import com.olpl.core_presentation.providers.LocalCurrentNavigator
import com.olpl.core_presentation.providers.util.currentNotNull
import com.olpl.settings_presentation.navigation.util.SettingsDestinations
import com.olpl.settings_presentation.ui.SettingsScreenRoot
import com.olpl.settings_presentation.ui.dialog_screens.ColorModeDialog
import com.olpl.settings_presentation.ui.dialog_screens.ColorsDialog
import com.olpl.settings_presentation.ui.dialog_screens.FontFamilyVariantsDialog

fun NavGraphBuilder.settingsGraph() {
   composable<AppDestinations.AccountGraph> {
        CompositionLocalProvider(
            LocalCurrentNavigator provides rememberNavController()
        ) {
            val currentNavController = LocalCurrentNavigator.currentNotNull()
            NavHost(
                navController = currentNavController,
                startDestination = SettingsDestinations.SettingsScreen
            ) {
                composable<SettingsDestinations.SettingsScreen> {
                    SettingsScreenRoot()
                }
                dialog<SettingsDestinations.ColorsDialog>(
                    dialogProperties = DialogProperties(
                        dismissOnBackPress = false,
                        dismissOnClickOutside = true,
                        usePlatformDefaultWidth = true
                    )
                ) {
                    ColorsDialog()
                }
                dialog<SettingsDestinations.ColorModeDialog>(
                    dialogProperties = DialogProperties(
                        dismissOnBackPress = false,
                        dismissOnClickOutside = true,
                        usePlatformDefaultWidth = true
                    )
                ) {
                    ColorModeDialog()
                }
                dialog<SettingsDestinations.FontFamilyVariantDialog>(
                    dialogProperties = DialogProperties(
                        dismissOnBackPress = false,
                        dismissOnClickOutside = true,
                        usePlatformDefaultWidth = true
                    )
                ) {
                    FontFamilyVariantsDialog()
                }
            }
        }
    }
}