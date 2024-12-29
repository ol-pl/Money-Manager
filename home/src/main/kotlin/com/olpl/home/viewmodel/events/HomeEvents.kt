package com.olpl.home.viewmodel.events

import com.olpl.core_presentation.viewmodel.util.events.Events

sealed interface HomeEvents : Events {
    data object OnBackAction : HomeEvents
}