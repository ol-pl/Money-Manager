package com.olpl.home.viewmodel

import com.olpl.core_presentation.viewmodel.util.ViewModelExp
import com.olpl.home.viewmodel.events.HomeEvents
import com.olpl.home.viewmodel.events.HomeUiEvents
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel : ViewModelExp<HomeEvents, HomeUiEvents>() {
    override fun onEvent(event: HomeEvents) {
        when (event) {
            HomeEvents.OnBackAction -> {

            }
        }
    }
}