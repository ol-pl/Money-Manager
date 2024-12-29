package com.olpl.settings_presentation.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import com.olpl.core_presentation.components.BaseScreen
import com.olpl.core_presentation.util.Qualifiers
import com.olpl.settings_presentation.viewmodel.SettingsScreenUiEventHandler
import com.olpl.settings_presentation.viewmodel.SettingsViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

@Composable
internal fun SettingsScreenRoot() {
    SettingsScreenUiEventHandler()

    val viewModelStoreOwner = koinInject<ViewModelStoreOwner>(
        qualifier = object : Qualifier {
            override val value: QualifierValue = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER
        }
    )
    val settingsViewModel = koinViewModel<SettingsViewModel>(
        viewModelStoreOwner = viewModelStoreOwner
    )
    BaseScreen(
        infoBarMessage = settingsViewModel.infoBarState,
        onInfoBarDismiss = {},
        onBackAction = {},
        topBar = {
            SettingsTopAppBar()
        }
    ) { paddings ->
        SettingsScreen(paddings)
    }
}