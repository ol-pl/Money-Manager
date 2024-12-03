package com.olpl.settings_presentation.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyItemScope
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
    tittle: StringId,
    onBackAction: () -> Unit,
    onCloseButtonClick: () -> Unit,
    content: @Composable LazyItemScope.() -> Unit
) {
    val paddings = LocalPaddings.current
    DialogScreen(
        onBackAction = onBackAction,
        confirmButton = {
            ElevatedButtonImpl(onClick = onCloseButtonClick) {
                TextImpl(
                    text = SharedStrings.Close.value,
                    textColor = colorScheme.primary
                )
            }
        }
    ) {
        DialogTittle(tittle)
        Spacer(Modifier.padding(paddings.extraSmall))
        content()
    }
}