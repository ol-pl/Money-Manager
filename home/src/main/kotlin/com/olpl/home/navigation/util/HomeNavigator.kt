package com.olpl.home.navigation.util

import androidx.compose.runtime.Immutable
import androidx.navigation.NavHostController
import com.olpl.core_presentation.navigation.NavigatorDef

@Immutable
internal class HomeNavigator(
    currentNavHostController: NavHostController
) : NavigatorDef(currentNavHostController)