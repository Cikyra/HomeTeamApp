package com.cikyra.hometeam.utils

import com.cikyra.hometeam.data.model.domain.Class
import com.cikyra.hometeam.data.model.domain.Day
import com.cikyra.hometeam.data.model.domain.Repeats
import com.cikyra.hometeam.data.model.domain.Schedule
import kotlinx.datetime.LocalDateTime
import java.util.UUID
import kotlin.time.Duration.Companion.hours

fun getMockClassData(): List<Class> {
    // 5pm April 1, 2025
    val firstClassStart = LocalDateTime(2025, 4, 1, 17, 0, 0)

    return listOf(
        Class(
            id = UUID.randomUUID().toString(),
            title = "Youth Yellow/Orange Belts",
            subtitle = "Room A",
            schedule = Schedule(
                startTime = firstClassStart,
                endTime = firstClassStart.later(1L.hours),
                days = listOf(
                    Day.MONDAY,
                    Day.TUESDAY,
                    Day.WEDNESDAY,
                    Day.THURSDAY,
                    Day.FRIDAY,
                    Day.SATURDAY
                ),
                repeats = Repeats.WEEKLY
            ),
            active = true,
            description = "Class for yellow and orange belts. Ages 7-11.",
            photoUrls = listOf(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        ),
        Class(
            id = UUID.randomUUID().toString(),
            title = "Adult",
            subtitle = "Room B",
            schedule = Schedule(
                startTime = firstClassStart,
                endTime = firstClassStart.later(1L.hours),
                days = listOf(
                    Day.MONDAY,
                    Day.TUESDAY,
                    Day.WEDNESDAY,
                    Day.THURSDAY,
                    Day.FRIDAY,
                    Day.SATURDAY
                ),
                repeats = Repeats.WEEKLY
            ),
            active = true,
            description = "Class for adults.",
            photoUrls = listOf(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        ),
        Class(
            id = UUID.randomUUID().toString(),
            title = "Youth White Belts",
            subtitle = "Room A",
            schedule = Schedule(
                startTime = firstClassStart.later(1L.hours),
                endTime = firstClassStart.later(2L.hours),
                days = listOf(
                    Day.MONDAY,
                    Day.TUESDAY,
                    Day.WEDNESDAY,
                    Day.THURSDAY,
                    Day.FRIDAY,
                    Day.SATURDAY
                ),
                repeats = Repeats.WEEKLY
            ),
            active = true,
            description = "Class for beginner kids. Ages 7-11.",
            photoUrls = listOf(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        ),
        Class(
            id = UUID.randomUUID().toString(),
            title = "Black Belts",
            subtitle = "Room A",
            schedule = Schedule(
                startTime = firstClassStart.later(1L.hours),
                endTime = firstClassStart.later(2L.hours),
                days = listOf(
                    Day.MONDAY,
                    Day.TUESDAY,
                    Day.WEDNESDAY,
                    Day.THURSDAY,
                    Day.FRIDAY,
                    Day.SATURDAY
                ),
                repeats = Repeats.WEEKLY
            ),
            active = true,
            description = "Class for the elite. Ages.",
            photoUrls = listOf(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        ),
        Class(
            id = UUID.randomUUID().toString(),
            title = "Champions",
            subtitle = "Room A",
            schedule = Schedule(
                startTime = firstClassStart.later(2L.hours),
                endTime = firstClassStart.later(3L.hours),
                days = listOf(
                    Day.MONDAY,
                    Day.TUESDAY,
                    Day.WEDNESDAY,
                    Day.THURSDAY,
                    Day.FRIDAY,
                    Day.SATURDAY
                ),
                repeats = Repeats.WEEKLY
            ),
            active = true,
            description = "Class for champions (aka babies). Ages baby-baby.",
            photoUrls = listOf(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    )
}