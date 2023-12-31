package com.itami.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ConsumedWaterResponse(
    val id: Int,
    val waterMl: Int,
    val timestamp: String,
    val userId: Int,
)
