package com.olpl.core_presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppDestinations : Destination {

    /* @Serializable
     data object SettingsGraph : AppDestinations()*/

    @Serializable
    data object HomeGraph : AppDestinations()

    @Serializable
    data object DashboardGraph : AppDestinations()

    @Serializable
    data object AccountGraph : AppDestinations()

}