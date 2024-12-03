package com.olpl.settings_presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.olpl.core_presentation.components.TextImpl
import com.olpl.core_presentation.providers.LocalPaddings
import com.olpl.core_presentation.util.Qualifiers
import com.olpl.settings_presentation.R
import com.olpl.settings_presentation.ui.components.SettingsCardImpl
import com.olpl.settings_presentation.viewmodel.SettingsViewModel
import com.olpl.settings_presentation.viewmodel.events.SettingsEvents
import com.olpl.utils.StringId
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

@Composable
internal fun SettingsScreen(paddingValues: PaddingValues) {
    val viewModelStoreOwner = koinInject<ViewModelStoreOwner>(
        qualifier = object : Qualifier {
            override val value: QualifierValue = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER
        }
    )
    val settingsViewModel = koinViewModel<SettingsViewModel>(
        viewModelStoreOwner = viewModelStoreOwner
    )
    val paddings = LocalPaddings.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentPadding = PaddingValues(
            top = paddings.medium,
            start = paddings.medium,
            end = paddings.medium,
            bottom = paddings.large
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(paddings.medium)
    ) {
        tittle(R.string.theme_tittle)
        colorTheme(settingsViewModel)
        colorMode(settingsViewModel)
        font(settingsViewModel)
        tittle(R.string.app_info_tittle)
        appVersionCardItem(settingsViewModel)
    }
}

private fun LazyListScope.colorTheme(settingsViewModel: SettingsViewModel) {
    item {
        val colorPalette = settingsViewModel.colorPalette.collectAsStateWithLifecycle()
        SettingsCardImpl(
            title = R.string.colors,
            onClick = {
                settingsViewModel.onEvent(SettingsEvents.OnColorsCardClick)
            },
            rightText = {
                TextImpl(text = colorPalette.value.title)
            }
        )
    }
}

private fun LazyListScope.colorMode(settingsViewModel: SettingsViewModel) {
    item {
        val colorMode = settingsViewModel.colorMode.collectAsStateWithLifecycle()
        SettingsCardImpl(
            title = R.string.color_mode,
            onClick = {
                settingsViewModel.onEvent(SettingsEvents.OnColorModeCardClick)
            },
            rightText = {
                TextImpl(text = colorMode.value.name)
            }
        )
    }
}

private fun LazyListScope.font(settingsViewModel: SettingsViewModel) {
    item {
        val font = settingsViewModel.fontFamilyVariants.collectAsStateWithLifecycle()
        SettingsCardImpl(
            title = R.string.font,
            onClick = {
                settingsViewModel.onEvent(SettingsEvents.OnFontCardClick)
            },
            rightText = {
                TextImpl(text = font.value.title)
            }
        )
    }
}

private fun LazyListScope.appVersionCardItem(settingsViewModel: SettingsViewModel) {
    item {
        val context = LocalContext.current
        val packageInfo = remember(context) {
            context.packageManager.getPackageInfo(context.packageName, 0)
        }
        SettingsCardImpl(
            showIcon = false,
            title = R.string.app_version,
            onClick = {},
            rightText = {
                TextImpl(text = packageInfo.versionName.toString())
            }
        )
    }
}

private fun LazyListScope.tittle(title: StringId) {
    item {
        TextImpl(
            textColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth(),
            text = title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Start,
            maxLines = 1
        )
    }
}