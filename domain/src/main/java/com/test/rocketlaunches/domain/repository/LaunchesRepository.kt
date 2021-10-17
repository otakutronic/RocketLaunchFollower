package com.test.rocketlaunches.domain.repository

import com.test.rocketlaunches.domain.model.Result
import com.test.rocketlaunches.domain.model.Launch

interface LaunchesRepository {

    suspend fun getRocketLaunches(rocketId: String) : Result<List<Launch>>

}
