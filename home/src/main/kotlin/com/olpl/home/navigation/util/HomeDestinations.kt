package com.olpl.home.navigation.util

import kotlinx.serialization.Serializable

@Serializable
internal sealed class HomeDestinations {

    @Serializable
    data object HomeScreen : HomeDestinations()

}