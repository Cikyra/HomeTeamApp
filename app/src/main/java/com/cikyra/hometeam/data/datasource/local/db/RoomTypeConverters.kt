package com.cikyra.hometeam.data.datasource.local.db

import androidx.room.TypeConverter
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

class RoomTypeConverters {
    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun epochMillisToLocalDateTime(value: Long): LocalDateTime {
        return Instant.fromEpochMilliseconds(value).toLocalDateTime(TimeZone.currentSystemDefault())
    }

    @TypeConverter
    fun localDateTimeToEpochMillis(localDateTime: LocalDateTime): Long {
        return localDateTime.toInstant(TimeZone.UTC).toEpochMilliseconds()
    }

    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        return list?.let { json.encodeToString(ListSerializer(String.serializer()), it) }
    }

    @TypeConverter
    fun toStringList(data: String?): List<String>? {
        return data?.let { json.decodeFromString(ListSerializer(String.serializer()), it) }
    }
}