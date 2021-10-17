package com.lush.rocketlaunches.data.di.submodule

import com.lush.rocketlaunches.data.remote.api.SpaceService
import com.lush.rocketlaunches.data.repository.implementation.LaunchesRepositoryImplementation
import com.lush.rocketlaunches.domain.repository.LaunchesRepository
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
