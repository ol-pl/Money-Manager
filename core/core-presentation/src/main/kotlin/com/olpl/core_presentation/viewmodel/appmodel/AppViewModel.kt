package com.olpl.core_presentation.viewmodel.appmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.olpl.core_presentation.navigation.AppDestinations
import com.olpl.core_presentation.viewmodel.appmodel.events.AppEvents
import com.olpl.core_presentation.viewmodel.appmodel.events.AppUiEvents
import com.olpl.core_presentation.viewmodel.util.ViewModelExp
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AppViewModel : ViewModelExp<AppEvents, AppUiEvents>() {

    private val _isBottomBarVisible = mutableStateOf(true)
    val isBottomBarVisible: State<Boolean> = _isBottomBarVisible

    override fun onEvent(event: AppEvents) {
        when (event) {
            AppEvents.OnCloseApp -> sendUiEvent(AppUiEvents.CloseApp)
            AppEvents.HideBottomBar -> _isBottomBarVisible.value = false
            AppEvents.ShowBottomBar -> _isBottomBarVisible.value = true
            is AppEvents.OnBottomBarItemClick -> onBottomBarItemClick(event.appDestination)
            AppEvents.OpenHome -> sendUiEvent(AppUiEvents.NavigateToHomeGraph)
        }
    }

    private fun onBottomBarItemClick(appDestinations: AppDestinations) {
        when (appDestinations) {
            AppDestinations.AccountGraph -> sendUiEvent(AppUiEvents.NavigateToAccountGraph)
            AppDestinations.DashboardGraph -> sendUiEvent(AppUiEvents.NavigateToDashboardGraph)
            AppDestinations.HomeGraph -> sendUiEvent(AppUiEvents.NavigateToHomeGraph)
        }
    }
}