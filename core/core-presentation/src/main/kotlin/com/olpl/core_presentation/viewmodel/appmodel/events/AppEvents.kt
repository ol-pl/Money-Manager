package com.olpl.core_presentation.viewmodel.appmodel.events

import com.olpl.core_presentation.navigation.AppDestinations
import com.olpl.core_presentation.viewmodel.util.events.Events

sealed interface AppEvents : Events {
    data object OnCloseApp : AppEvents
    data object HideBottomBar : AppEvents
    data object ShowBottomBar : AppEvents
    data object OpenHome:AppEvents
    data class OnBottomBarItemClick(val appDestination: AppDestinations) : AppEvents
}