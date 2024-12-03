package com.olpl.settings_presentation.ui.dialog_screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.olpl.core_presentation.components.RadioButtonImpl
import com.olpl.core_presentation.theme.util.PaletteVariants
import com.olpl.core_presentation.util.Qualifiers
import com.olpl.settings_presentation.R
import com.olpl.settings_presentation.ui.components.SettingsDialogScreenImpl
import com.olpl.settings_presentation.viewmodel.SettingsViewModel
import com.olpl.settings_presentation.viewmodel.events.SettingsEvents
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

@Composable
internal fun ColorsDialog() {
    val viewModelStoreOwner = koinInject<ViewModelStoreOwner>(qualifier = object : Qualifier {
        override val value: QualifierValue = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER
    })
    val settingsViewModel = koinViewModel<SettingsViewModel>(
        viewModelStoreOwner = viewModelStoreOwner
    )
    SettingsDialogScreenImpl(
        tittle = R.string.colors,
        onBackAction = {
            settingsViewModel.onEvent(SettingsEvents.GoBack)
        },
        onCloseButtonClick = {
            settingsViewModel.onEvent(SettingsEvents.GoBack)
        },
        content = {
            Content(
                currentPalette = settingsViewModel.colorPalette
            ) { palette ->
                settingsViewModel.onEvent(SettingsEvents.SetColorPalette(palette))
            }
        }
    )
}

@Composable
private fun LazyItemScope.Content(
    currentPalette: StateFlow<PaletteVariants>,
    onClick: (PaletteVariants) -> Unit
) {
    val selectedPalette = currentPalette.collectAsStateWithLifecycle()
    PaletteVariants.getAll().forEach { palette ->
        val interactionSource = remember {
            MutableInteractionSource()
        }
        RadioButtonImpl(
            text = palette.title,
            selected = selectedPalette.value == palette,
            mutableInteractionSource = interactionSource,
            onClick = {
                onClick(palette)
            }
        )
    }
}