package com.olpl.core_presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.olpl.core_presentation.viewmodel.util.ViewModelExp
import com.olpl.core_presentation.viewmodel.util.events.Events
import com.olpl.core_presentation.viewmodel.util.events.UiEvents
import kotlinx.coroutines.flow.collectLatest

@Composable
fun <E : Events, UiE : UiEvents> UiEventsHandler(
    viewModel: ViewModelExp<E, UiE>,
    onNewEvent: suspend (UiE) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.uiEvents.collectLatest { uiEvent ->
            onNewEvent(uiEvent)
        }
    }
}
