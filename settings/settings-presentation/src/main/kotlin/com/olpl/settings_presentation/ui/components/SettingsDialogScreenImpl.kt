package com.olpl.settings_presentation.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olpl.core_presentation.components.DialogScreen
import com.olpl.core_presentation.components.ElevatedButtonImpl
import com.olpl.core_presentation.components.TextImpl
import com.olpl.core_presentation.providers.LocalPaddings
import com.olpl.core_presentation.util.SharedStrings
import com.olpl.utils.StringId

@Composable
internal fun SettingsDialogScreenImpl(
    title: StringId,
    onBackAction: () -> Unit,
    onCloseButtonClick: () -> Unit,
    content: @Composable LazyItemScope.() -> Unit
) {
    val paddings = LocalPaddings.current
    DialogScreen(
        onBackAction = onBackAction,
        confirmButton = {
            ElevatedButtonImpl(
                onClick = onCloseButtonClick,
                colors = ButtonDefaults.elevatedButtonColors(containerColor = colorScheme.tertiary)
            ) {
                TextImpl(
                    text = SharedStrings.Close.value,
                    textColor = colorScheme.onTertiary
                )
            }
        }
    ) {
        DialogTittle(title)
        Spacer(Modifier.padding(paddings.extraSmall))
        content()
    }
}