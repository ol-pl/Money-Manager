package com.olpl.home.ui

import androidx.compose.runtime.Composable
import com.olpl.core_presentation.components.BaseScreen
import com.olpl.home.viewmodel.HomeScreenUiEventHandler
import com.olpl.home.viewmodel.HomeViewModel
import com.olpl.home.viewmodel.events.HomeEvents
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun HomeScreenRoot() {
    HomeScreenUiEventHandler()

    val homeViewModel = koinViewModel<HomeViewModel>()
    BaseScreen(
        infoBarMessage = homeViewModel.infoBarState,
        onInfoBarDismiss = homeViewModel::hideInfoBar,
        onBackAction = { homeViewModel.onEvent(HomeEvents.OnBackAction) }
    ) { paddings ->

    }
}
