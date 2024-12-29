package com.olpl.core_presentation.navigation

import androidx.navigation.NavHostController

abstract class NavigatorDef(val navHostController: NavHostController) {

    /***
     * @param T to which we navigate
     * Automatically popUp to current route
     */
    inline fun <reified T : Destination> navigateTo(navigateTo: T) {
        val routeToPopUp = navHostController.currentDestination?.route
        navigateTo(
            route = navigateTo,
            popUpToRoute = routeToPopUp,
        )
    }

    inline fun <reified T : Destination> navigateTo(
        route: T,
        popUpToRoute: T? = null,
        inclusiveEnabled: Boolean = true,
        saveStateEnabled: Boolean = true,
        restoreStateEnabled: Boolean = true
    ) {
        navHostController.navigate(route) {
            popUpToRoute?.let {
                popUpTo(popUpToRoute) {
                    inclusive = inclusiveEnabled
                    saveState = saveStateEnabled
                }
                restoreState = restoreStateEnabled
            }
        }
    }

    inline fun <reified T : Destination> navigateTo(
        route: T,
        popUpToRoute: String? = null,
        inclusiveEnabled: Boolean = true,
        saveStateEnabled: Boolean = true,
        restoreStateEnabled: Boolean = true
    ) {
        navHostController.navigate(route) {
            popUpToRoute?.let {
                popUpTo(popUpToRoute) {
                    inclusive = inclusiveEnabled
                    saveState = saveStateEnabled
                }
                restoreState = restoreStateEnabled
            }
        }
    }

    fun navigateUp() {
        navHostController.navigateUp()
    }
}