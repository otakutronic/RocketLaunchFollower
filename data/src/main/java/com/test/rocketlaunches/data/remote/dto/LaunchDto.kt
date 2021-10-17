package com.test.rocketlaunches.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.test.rocketlaunches.domain.model.Launch

data class LaunchDto(
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("mission_name")
    val missionName: String,
    @SerializedName("launch_date_unix")
    val launchDateUnix: Long?,
    @SerializedName("launch_success")
    val launchSuccess: Boolean,
    @SerializedName("links")
    val link: Link?,
) {

    data class Link(
        @SerializedName("mission_patch_small")
        val missionPatchSmall: String?,
    )
}

fun LaunchDto.toLaunch(): Launch {
    return Launch(
        id = flightNumber,
        missionName = missionName,
        date = launchDateUnix,
        success = launchSuccess,
        imageUrl = link?.missionPatchSmall
    )
}
