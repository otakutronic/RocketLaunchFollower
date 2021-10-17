package com.test.rocketlaunches.data.repository.implementation

import com.test.rocketlaunches.data.remote.api.SpaceService
import com.test.rocketlaunches.domain.repository.LaunchesRepository
import com.test.rocketlaunches.data.remote.dto.toLaunch
import com.test.rocketlaunches.domain.model.Launch
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import com.test.rocketlaunches.domain.model.Result

class LaunchesRepositoryImplementation(
    private val apiService: SpaceService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseImplementation(), LaunchesRepository {

    override suspend fun getRocketLaunches(rocketId: String): Result<List<Launch>> {
        return getResult(
            { apiService.getRocketLaunches(rocketId) },
            { it.map { launchDto -> launchDto.toLaunch() } })
    }
}
