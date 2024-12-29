package com.olpl.home.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import com.olpl.core_presentation.components.UiEventsHandler
import com.olpl.core_presentation.providers.LocalCurrentNavigator
import com.olpl.core_presentation.providers.util.currentNotNull
import com.olpl.core_presentation.util.Qualifiers
import com.olpl.core_presentation.viewmodel.appmodel.AppViewModel
import com.olpl.core_presentation.viewmodel.appmodel.events.AppEvents
import com.olpl.home.navigation.util.HomeNavigator
import com.olpl.home.viewmodel.events.HomeUiEvents
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

@Composable
internal fun HomeScreenUiEventHandler() {
    val homeViewModel = koinViewModel<HomeViewModel>()
    val globalViewModelStoreOwner = koinInject<ViewModelStoreOwner>(
        qualifier = object : Qualifier {
            override val value: QualifierValue = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER
        }
    )
    val appViewModel = koinViewModel<AppViewModel>(viewModelStoreOwner = globalViewModelStoreOwner)
    val currentNavHostController = LocalCurrentNavigator.currentNotNull()
    val navigator = HomeNavigator(currentNavHostController)

    UiEventsHandler(viewModel = homeViewModel) { uiEvent ->
        when (uiEvent) {
            HomeUiEvents.CloseApp -> appViewModel.onEvent(AppEvents.OnCloseApp)
        }
    }
}