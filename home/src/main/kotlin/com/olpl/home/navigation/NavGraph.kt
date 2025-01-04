package com.olpl.home.navigation

import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.olpl.core_presentation.navigation.AppDestinations
import com.olpl.core_presentation.navigation.composableImpl
import com.olpl.core_presentation.providers.LocalCurrentNavigator
import com.olpl.core_presentation.providers.util.currentNotNull
import com.olpl.home.navigation.util.HomeDestinations
import com.olpl.home.ui.HomeScreenRoot

fun NavGraphBuilder.homeGraph() {
    composableImpl<AppDestinations.HomeGraph> {
        CompositionLocalProvider(
            LocalCurrentNavigator provides rememberNavController()
        ) {
            val currentNavHostController = LocalCurrentNavigator.currentNotNull()
            NavHost(
                navController = currentNavHostController,
                startDestination = HomeDestinations.HomeScreen
            ) {
                composableImpl<HomeDestinations.HomeScreen> {
                    HomeScreenRoot()
                }
            }
        }
    }
}