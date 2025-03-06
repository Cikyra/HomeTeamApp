package com.cikyra.hometeam.compose.nav

import com.cikyra.hometeam.R
import kotlinx.serialization.Serializable

interface TopLevelRoute {
    val name: Int
    val activeIcon: Int
    val inactiveIcon: Int
}

object AppRoutes {
    @Serializable
    object SplashScreen

    @Serializable
    data class Home(
        override val name: Int = R.string.home,
        override val activeIcon: Int = R.drawable.home_icon_active,
        override val inactiveIcon: Int = R.drawable.home_icon_inactive
    ): TopLevelRoute
    val home = Home()

    @Serializable
    data class Schedule(
        override val name: Int = R.string.schedule,
        override val activeIcon: Int = R.drawable.schedule_icon_active,
        override val inactiveIcon: Int = R.drawable.schedule_icon_inactive
    ): TopLevelRoute
    val schedule = Schedule()

    @Serializable
    data class Report(
        override val name: Int = R.string.report,
        override val activeIcon: Int = R.drawable.report_icon_active,
        override val inactiveIcon: Int = R.drawable.report_icon_inactive
    ): TopLevelRoute
    val report = Report()

    @Serializable
    data class Videos(
        override val name: Int = R.string.videos,
        override val activeIcon: Int = R.drawable.video_icon_active,
        override val inactiveIcon: Int = R.drawable.video_icon_inactive
    ): TopLevelRoute
    val videos = Videos()

    @Serializable
    data class Shop(
        override val name: Int = R.string.shop,
        override val activeIcon: Int = R.drawable.shop_icon_active,
        override val inactiveIcon: Int = R.drawable.shop_icon_inactive
    ): TopLevelRoute
    val shop = Shop()

    @Serializable
    data class VideoDetail(val id: String) // TODO: Can use Video model here whenever we define it

    val topLevelRoutes = listOf(home, schedule, report, videos, shop)
}