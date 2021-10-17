package com.test.rocketlaunches.data.remote.api

import com.test.rocketlaunches.data.remote.dto.LaunchDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceService {

    @GET("v3/launches?")
    suspend fun getRocketLaunches(
        @Query("rocket_id") symbol: String
    ): Response<List<LaunchDto>>

}
