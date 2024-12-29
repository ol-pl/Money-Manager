package com.olpl.home.viewmodel.events

import com.olpl.core_presentation.viewmodel.util.events.UiEvents

sealed interface HomeUiEvents : UiEvents {
    data object CloseApp : HomeUiEvents
}