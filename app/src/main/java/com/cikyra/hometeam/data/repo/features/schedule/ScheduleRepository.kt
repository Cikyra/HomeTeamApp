package com.cikyra.hometeam.data.repo.features.schedule

import com.cikyra.hometeam.data.model.domain.ScheduleFeed
import kotlinx.datetime.LocalDateTime

interface ScheduleRepository {
    suspend fun getClasses(startDate: LocalDateTime?, endDate: LocalDateTime?): Result<ScheduleFeed>
}