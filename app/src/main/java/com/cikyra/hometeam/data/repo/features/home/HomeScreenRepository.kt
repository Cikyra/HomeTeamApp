package com.cikyra.hometeam.data.repo.features.home

import com.cikyra.hometeam.data.model.domain.Announcement

interface HomeScreenRepository {
    fun getMyWeek()
    suspend fun getAnnouncements(): Result<List<Announcement>>
    fun getEvents()
}