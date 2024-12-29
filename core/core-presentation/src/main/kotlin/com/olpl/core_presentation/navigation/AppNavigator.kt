package com.olpl.core_presentation.navigation

import androidx.compose.runtime.Immutable
import androidx.navigation.NavHostController

@Immutable
class AppNavigator(
    mainNavHostController: NavHostController
) : NavigatorDef(mainNavHostController)