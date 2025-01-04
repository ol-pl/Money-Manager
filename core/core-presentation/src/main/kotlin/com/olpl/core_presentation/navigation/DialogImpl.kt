package com.olpl.core_presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.DialogNavigator
import androidx.navigation.compose.DialogNavigatorDestinationBuilder
import androidx.navigation.get
import kotlin.reflect.KType

inline fun <reified T : Any> NavGraphBuilder.dialogImpl(
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    dialogProperties: DialogProperties = DialogProperties(
        dismissOnBackPress = false,
        dismissOnClickOutside = true,
        usePlatformDefaultWidth = true
    ),
    noinline content: @Composable (NavBackStackEntry) -> Unit
) {
    destination(
        DialogNavigatorDestinationBuilder(
            provider[DialogNavigator::class],
            T::class,
            typeMap,
            dialogProperties,
            content
        )
    )
}
