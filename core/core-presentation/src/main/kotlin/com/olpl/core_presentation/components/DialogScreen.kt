package com.olpl.core_presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.olpl.core_presentation.providers.LocalElevations
import com.olpl.core_presentation.providers.LocalPaddings
import com.olpl.core_presentation.providers.Paddings

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DialogScreen(
    modifier: Modifier = Modifier,
    onBackAction: () -> Unit,
    confirmButton: @Composable () -> Unit,
    dismissButton: @Composable () -> Unit = {},
    content: @Composable LazyItemScope.() -> Unit,
) {
    val elevation = LocalElevations.current
    val paddings = LocalPaddings.current
    val configuration = LocalConfiguration.current
    val maxHeight = (configuration.screenHeightDp * 0.5f).dp

    BackHandler(onBack = onBackAction)

    Surface(
        color = MaterialTheme.colorScheme.tertiary,
        contentColor = MaterialTheme.colorScheme.onTertiary,
        modifier = Modifier.heightIn(max = maxHeight) then modifier ,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shadowElevation = elevation.medium,
        tonalElevation = elevation.medium,
        content = {
            LazyColumn (
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(paddings.medium),
                verticalArrangement = Arrangement.spacedBy(paddings.extraSmall),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    content()
                }
                item {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalArrangement = Arrangement.Center
                    ) {
                        dismissButton()
                        confirmButton()
                    }
                }
            }
        }
    )
}