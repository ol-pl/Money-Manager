package com.olpl.money_manager.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.olpl.core_presentation.components.TextImpl
import com.olpl.core_presentation.navigation.AppDestinations
import com.olpl.core_presentation.providers.LocalElevations
import com.olpl.core_presentation.providers.LocalMainNavigator
import com.olpl.core_presentation.providers.LocalPaddings
import com.olpl.core_presentation.providers.util.currentNotNull
import com.olpl.money_manager.R
import com.olpl.utils.IconId
import com.olpl.utils.StringId

@Composable
fun AppBottomBar(
    onClick: (AppDestinations) -> Unit
) {
    val mainNavHostController = LocalMainNavigator.currentNotNull()
    val currentBackStackEntry = mainNavHostController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry.value?.destination

    val bottomBarItems = AppBottomBarItems.getBottomBarItems()
    val paddings = LocalPaddings.current
    val elevation = LocalElevations.current
    Box(
        Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        Alignment.BottomCenter
    ) {
        BottomAppBar(
            modifier = Modifier
                .padding(bottom = paddings.large)
                .fillMaxWidth(0.8f)
                .clip(MaterialTheme.shapes.extraLarge),
            containerColor = colorScheme.primary,
            tonalElevation = elevation.medium
        ) {
            bottomBarItems.forEach { item ->
                AppBottomBarItemImpl(
                    currentItem = item,
                    isSelected = item.isSelected(currentDestination),
                    onClick = onClick
                )
            }
        }
    }
}

@Composable
private fun RowScope.AppBottomBarItemImpl(
    currentItem: AppBottomBarItems,
    isSelected: Boolean,
    onClick: (AppDestinations) -> Unit
) {
    val currentItemSize = animateDpAsState(
        targetValue = if (isSelected) 28.5.dp else 32.5.dp,
        label = "bottom bar item size"
    )

    NavigationBarItem(
        selected = isSelected,
        onClick = { onClick(currentItem.destination) },
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(currentItem.iconId),
                contentDescription = "App bottom bar icon",
                modifier = Modifier.size(currentItemSize.value)
            )
        },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = colorScheme.secondary,
            selectedIconColor = colorScheme.onPrimary,
            unselectedIconColor = colorScheme.onPrimary,
            disabledIconColor = colorScheme.onPrimary,
        ),
        label = {
            TextImpl(text = currentItem.tittle)
        }, alwaysShowLabel = false,
        enabled = isSelected.not()
    )
}

private fun AppBottomBarItems.isSelected(currentDestination: NavDestination?): Boolean {
    return currentDestination?.route == this.destination::class.java.canonicalName
}

private sealed class AppBottomBarItems(
    val tittle: StringId,
    val iconId: IconId,
    val destination: AppDestinations
) {
    data object Dashboard : AppBottomBarItems(
        tittle = R.string.dashboard_title,
        iconId = R.drawable.dashboard_icon,
        destination = AppDestinations.DashboardGraph
    )

    data object Home : AppBottomBarItems(
        tittle = R.string.home_title,
        iconId = R.drawable.home_icon,
        destination = AppDestinations.HomeGraph
    )

    data object Account : AppBottomBarItems(
        tittle = R.string.account_title,
        iconId = R.drawable.account_icon,
        destination = AppDestinations.AccountGraph
    )

    companion object {
        fun getBottomBarItems(): List<AppBottomBarItems> = listOf(
            Dashboard,
            Home,
            Account
        )
    }
}