package com.olpl.money_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.olpl.core_presentation.components.BaseContainer
import com.olpl.core_presentation.navigation.AppDestinations
import com.olpl.core_presentation.providers.LocalMainNavigator
import com.olpl.core_presentation.providers.util.currentNotNull
import com.olpl.core_presentation.theme.MoneyManagerTheme
import com.olpl.core_presentation.util.Qualifiers
import com.olpl.core_presentation.viewmodel.appmodel.AppUiEventsHandler
import com.olpl.core_presentation.viewmodel.appmodel.AppViewModel
import com.olpl.core_presentation.viewmodel.appmodel.events.AppEvents
import com.olpl.home.navigation.homeGraph
import com.olpl.money_manager.ui.components.AppBottomBar
import com.olpl.settings_presentation.navigation.settingsGraph
import com.olpl.settings_presentation.viewmodel.SettingsViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModelStoreOwner = koinInject<ViewModelStoreOwner>(
                qualifier = object : Qualifier {
                    override val value: QualifierValue = Qualifiers.GLOBAL_VIEW_MODEL_STORE_OWNER
                }
            )
            val settingsViewModel = koinViewModel<SettingsViewModel>(
                viewModelStoreOwner = viewModelStoreOwner
            )
            val appViewModel = koinViewModel<AppViewModel>(
                viewModelStoreOwner = viewModelStoreOwner
            )


            MoneyManagerTheme(
                colorModeState = settingsViewModel.colorMode,
                paletteVariantsState = settingsViewModel.colorPalette,
                fontFamilyVariantsState = settingsViewModel.fontFamilyVariants
            ) {
                CompositionLocalProvider(
                    LocalMainNavigator provides rememberNavController()
                ) {
                    AppUiEventsHandler()

                    val mainNavController = LocalMainNavigator.currentNotNull()
                    BaseContainer(
                        bottomBar = {
                            if (appViewModel.isBottomBarVisible.value) {
                                AppBottomBar { appDestination ->
                                    appViewModel.onEvent(
                                        AppEvents.OnBottomBarItemClick(appDestination)
                                    )
                                }
                            }
                        }
                    ) { paddings ->
                        NavHost(
                            modifier = Modifier.padding(bottom = paddings.calculateBottomPadding()),
                            navController = mainNavController,
                            startDestination = AppDestinations.HomeGraph
                        ) {

                            homeGraph()
                            composable<AppDestinations.DashboardGraph> { }
                            settingsGraph()
                        }
                    }
                }
            }
        }
    }
}
