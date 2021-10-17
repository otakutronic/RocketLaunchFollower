package com.lush.rocketlaunches.domain.repository

import com.lush.rocketlaunches.domain.model.Result
import com.lush.rocketlaunches.domain.model.Launch

interface LaunchesRepository {

    suspend fun getRocketLaunches(rocketId: String) : Result<List<Launch>>

}
