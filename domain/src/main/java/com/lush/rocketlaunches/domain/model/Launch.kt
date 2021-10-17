package com.lush.rocketlaunches.domain.model

data class Launch(
    val id: Int,
    val missionName: String,
    val date: Long?,
    val success: Boolean,
    val imageUrl: String?
)
