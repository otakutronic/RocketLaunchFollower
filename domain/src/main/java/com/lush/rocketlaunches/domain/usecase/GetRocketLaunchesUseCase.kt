package com.lush.rocketlaunches.domain.usecase

import com.lush.rocketlaunches.domain.repository.LaunchesRepository
import com.lush.rocketlaunches.domain.model.Launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.lush.rocketlaunches.domain.model.Result

class GetRocketLaunchesUseCase(private val repository: LaunchesRepository) {

    operator fun invoke(rocketId: String): Flow<Result<List<Launch>>> = flow {
        emit(Result.loading())
        val launches = repository.getRocketLaunches(rocketId)
        emit(launches)
    }
}
