package com.olpl.settings_presentation.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import com.olpl.core_presentation.components.UiEventsHandler
import com.olpl.core_presentation.providers.LocalCurrentNavigator
import com.olpl.core_presentation.providers.util.currentNotNull
import com.olpl.core_presentation.util.Qualifiers
import com.olpl.settings_presentation.navigation.util.SettingsDestinations
import com.olpl.settings_presentation.navigation.util.SettingsNavigator
import com.olpl.settings_presentation.viewmodel.events.SettingsUiEvents
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

@Composable
internal fun SettingsScreenUiEventHandler() {
    val viewModelStoreOwner = koinInject<ViewModelStoreOwner>(
        qualifier = object : Qualifier {
            override val value: QualifierValue = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER
        }
    )
    val settingsViewModel = koinViewModel<SettingsViewModel>(
        viewModelStoreOwner = viewModelStoreOwner
    )
    val currentNavHostController = LocalCurrentNavigator.currentNotNull()
    val navigator = SettingsNavigator(currentNavHostController)

    UiEventsHandler(viewModel = settingsViewModel) { uiEvent ->
        when (uiEvent) {
            SettingsUiEvents.GoBack -> navigator.navigateUp()
            SettingsUiEvents.OpenColorModeDialog -> navigator.navigateTo(
                route = SettingsDestinations.ColorModeDialog,
                popUpToCurrentRoute = false
            )

            SettingsUiEvents.OpenColorsDialog -> navigator.navigateTo(
                route = SettingsDestinations.ColorsDialog,
                popUpToCurrentRoute = false
            )

            SettingsUiEvents.OpenFontFamilyVariantDialog -> navigator.navigateTo(
                route = SettingsDestinations.FontFamilyVariantDialog,
                popUpToCurrentRoute = false
            )
        }
    }
}