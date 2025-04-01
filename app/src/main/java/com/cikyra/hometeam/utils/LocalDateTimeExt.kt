package com.cikyra.hometeam.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration

fun LocalDateTime.Companion.now(): LocalDateTime {
    return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
}

fun LocalDateTime.later(duration: Duration): LocalDateTime {
    return this.toInstant(TimeZone.currentSystemDefault()).plus(duration).toLocalDateTime(TimeZone.currentSystemDefault())
}