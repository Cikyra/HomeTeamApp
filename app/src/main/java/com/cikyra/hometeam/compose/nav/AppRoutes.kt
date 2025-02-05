package com.cikyra.hometeam.compose.nav

import kotlinx.serialization.Serializable

object AppRoutes {
    @Serializable
    object SplashScreen

    @Serializable
    data class HomeScreen(val id: String) // TODO: Remove this, just for show

    @Serializable
    data class VideoDetail(val id: String) // TODO: Can use Video model here whenever we define it
}