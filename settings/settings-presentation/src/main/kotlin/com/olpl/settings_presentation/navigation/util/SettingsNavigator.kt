package com.olpl.settings_presentation.navigation.util

import androidx.compose.runtime.Immutable
import androidx.navigation.NavHostController
import com.olpl.core_presentation.navigation.NavigatorDef

@Immutable
internal class SettingsNavigator(
    currentNavHostController: NavHostController
) : NavigatorDef(currentNavHostController)