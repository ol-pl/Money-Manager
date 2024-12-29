package com.olpl.core_presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.olpl.core_presentation.providers.LocalElevations
import com.olpl.core_presentation.providers.LocalPaddings
import com.radusalagean.infobarcompose.InfoBar
import com.radusalagean.infobarcompose.InfoBarMessage

@Composable
fun InfoBarImpl(
    infoBarMessage: State<InfoBarMessage?>,
    onDismiss: () -> Unit
) {
    val elevation = LocalElevations.current
    val configuration = LocalConfiguration.current
    val minWidth = (configuration.screenWidthDp * 0.45f).dp
    val maxWidth = (configuration.screenWidthDp * 0.75f).dp

    val paddings = LocalPaddings.current

    Box(
        Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = paddings.small),
        contentAlignment = Alignment.Center
    ) {
        InfoBar(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .widthIn(min = minWidth, max = maxWidth)
                .width(IntrinsicSize.Max),
            wrapInsideExpandedBox = false,
            offeredMessage = infoBarMessage.value,
            elevation = elevation.medium,
            textColor = colorScheme.onPrimary,
            backgroundColor = colorScheme.secondary,
            actionColor = colorScheme.primary,
            textStyle = typography.bodyLarge,
            shape = shapes.medium,
            onDismiss = onDismiss
        )
    }
}