package com.test.rocketlaunches.data.di.submodule

import com.test.rocketlaunches.data.remote.api.SpaceService
import com.test.rocketlaunches.data.repository.implementation.LaunchesRepositoryImplementation
import com.test.rocketlaunches.domain.repository.LaunchesRepository
import org.koin.dsl.module
import retrofit2.Retrofit

fun provideApiService(retrofit: Retrofit): SpaceService =
    retrofit.create(SpaceService::class.java)

fun provideApiRepository(service: SpaceService): LaunchesRepository =
    LaunchesRepositoryImplementation(service)

val apiRepositoryModule = module {
    factory { provideApiService(get()) }
    factory { provideApiRepository(get()) }
}
