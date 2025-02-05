package com.cikyra.hometeam.data.repo.impl

import android.util.Log
import com.cikyra.hometeam.data.repo.HomeScreenRepository
import javax.inject.Inject

class HomeScreenRepositoryImpl @Inject constructor(

): HomeScreenRepository {
    override fun returnGreeting(): String {
        Log.d("HomeScreenRepositoryImpl", "Logging example")
        return "Hello from Repository"
    }

    override fun getAnnouncements() {
        TODO("Not yet implemented")
    }

    override fun getSchedule() {
        TODO("Not yet implemented")
    }

    override fun getEvents() {
        TODO("Not yet implemented")
    }
}