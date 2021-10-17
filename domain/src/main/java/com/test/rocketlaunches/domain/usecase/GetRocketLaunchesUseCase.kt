package com.test.rocketlaunches.domain.usecase

import com.test.rocketlaunches.domain.repository.LaunchesRepository
import com.test.rocketlaunches.domain.model.Launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.test.rocketlaunches.domain.model.Result

class GetRocketLaunchesUseCase(private val repository: LaunchesRepository) {

    operator fun invoke(rocketId: String): Flow<Result<List<Launch>>> = flow {
        emit(Result.Loading())
        val launches = repository.getRocketLaunches(rocketId)
        emit(launches)
    }
}
