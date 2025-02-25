package com.cikyra.hometeam.data.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Class(
    val id: String,
    val title: String,
    val subtitle: String? = null,

    //schedule


    val active: Boolean,
    val description: String? = null,
    @SerialName("photo_urls") val photoUrls: List<String>? = null,

    //registration

    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
