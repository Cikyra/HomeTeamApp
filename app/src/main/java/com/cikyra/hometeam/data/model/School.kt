package com.cikyra.hometeam.data.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class School(
    val id: String,
    val name: String,
    val address: String,
    val classes: List<String>,
    val events: List<String>,
    val announcements: List<String>,
    val users: List<String>,
    val levels: List<String>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    )
