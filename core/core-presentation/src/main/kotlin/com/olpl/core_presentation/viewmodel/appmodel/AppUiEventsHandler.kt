package com.olpl.core_presentation.viewmodel.appmodel

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelStoreOwner
import com.olpl.core_presentation.components.UiEventsHandler
import com.olpl.core_presentation.navigation.AppDestinations
import com.olpl.core_presentation.navigation.AppNavigator
import com.olpl.core_presentation.providers.LocalMainNavigator
import com.olpl.core_presentation.providers.util.currentNotNull
import com.olpl.core_presentation.util.Qualifiers
import com.olpl.core_presentation.viewmodel.appmodel.events.AppUiEvents
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

@Composable
fun AppUiEventsHandler() {
    val globalViewModelStoreOwner = koinInject<ViewModelStoreOwner>(
        qualifier = object : Qualifier {
            override val value: QualifierValue = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER
        }
    )
    val appViewModel = koinViewModel<AppViewModel>(viewModelStoreOwner = globalViewModelStoreOwner)
    val mainNavHostController = LocalMainNavigator.currentNotNull()
    val navigator = AppNavigator(mainNavHostController)
    val context = LocalContext.current

    UiEventsHandler(viewModel = appViewModel) { uiEvents ->
        when (uiEvents) {
            AppUiEvents.CloseApp -> (context as Activity).finish()
            AppUiEvents.NavigateToAccountGraph -> navigator.navigateTo(navigateTo = AppDestinations.AccountGraph)
            AppUiEvents.NavigateToDashboardGraph -> navigator.navigateTo(navigateTo = AppDestinations.DashboardGraph)
            AppUiEvents.NavigateToHomeGraph -> navigator.navigateTo(navigateTo = AppDestinations.HomeGraph)
        }
    }
}