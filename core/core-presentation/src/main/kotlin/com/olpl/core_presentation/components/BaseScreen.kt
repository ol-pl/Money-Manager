package com.olpl.core_presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.radusalagean.infobarcompose.InfoBarMessage

@Composable
fun BaseScreen(
    infoBarMessage: State<InfoBarMessage?>,
    onInfoBarDismiss: () -> Unit,
    onBackAction: () -> Unit,
    topBar: @Composable (() -> Unit) = {},
    bottomBar: @Composable (() -> Unit) = {},
    floatingActionButton: @Composable (() -> Unit) = {},
    content: @Composable (PaddingValues) -> Unit
) {
    BackHandler(onBack = onBackAction)
    BaseContainer(
        topBar = topBar,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        content = content
    )
    InfoBarImpl(infoBarMessage, onInfoBarDismiss)
}