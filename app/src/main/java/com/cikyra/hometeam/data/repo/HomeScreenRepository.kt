package com.cikyra.hometeam.data.repo

interface HomeScreenRepository {
    fun returnGreeting(): String

    fun getAnnouncements()
    fun getSchedule()
    fun getEvents()
}