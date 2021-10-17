package com.lush.rocketlaunches.home

import com.lush.rocketlaunches.data.di.networkModule
import com.lush.rocketlaunches.data.di.submodule.apiRepositoryModule
import com.lush.rocketlaunches.domain.di.general.dispatcherModules
import com.lush.rocketlaunches.domain.di.general.rocketLaunchesUseCaseModule
import com.lush.rocketlaunches.home.di.homeModules

val domainModules = listOf(rocketLaunchesUseCaseModule, dispatcherModules)
val dataModules = listOf(networkModule, apiRepositoryModule)
val vmModules = listOf(homeModules)
val testModules = dataModules + domainModules + vmModules