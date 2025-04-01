package com.cikyra.hometeam.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import java.util.UUID

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: UUID,
    val schoolIds: List<String>,
    val name: String,
    val childrenIds: List<String>,
    val eventIds: List<String>,
    val classIds: List<String>,
    val photoUrl: String? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)