package com.olpl.core_presentation.viewmodel.appmodel.events

import com.olpl.core_presentation.viewmodel.util.events.UiEvents

sealed interface AppUiEvents : UiEvents {
    data object CloseApp : AppUiEvents
    data object NavigateToAccountGraph : AppUiEvents
    data object NavigateToHomeGraph : AppUiEvents
    data object NavigateToDashboardGraph : AppUiEvents
}