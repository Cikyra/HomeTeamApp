package com.cikyra.hometeam.data.repo.features.schedule.impl

import android.content.SharedPreferences
import com.cikyra.hometeam.data.datasource.local.HomeTeamLocalDataSource
import com.cikyra.hometeam.data.model.domain.Class
import com.cikyra.hometeam.data.model.domain.ScheduleFeed
import com.cikyra.hometeam.data.repo.features.schedule.ScheduleRepository
import com.cikyra.hometeam.utils.AppPreferences
import com.cikyra.hometeam.utils.getMockClassData
import kotlinx.datetime.LocalDateTime
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    // val remoteDataSource: HomeTeamRemoteDataSource
    private val localDataSource: HomeTeamLocalDataSource,
    private val sharedPrefs: SharedPreferences
): ScheduleRepository {
    override suspend fun getClasses(
        startDate: LocalDateTime?,
        endDate: LocalDateTime?
    ): Result<ScheduleFeed> {
        // TODO: Actually fetch data
        val getClassesResult = getMockClassData()
        val currentUserId = sharedPrefs.getString(AppPreferences.CURRENT_USER_ID, "")
        val getCurrentUser = localDataSource.getUserById(currentUserId!!)

        return Result.success(ScheduleFeed(date = "TODAY"))
    }
}