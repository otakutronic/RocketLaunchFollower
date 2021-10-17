package com.test.rocketlaunches.home.ui

import com.test.rocketlaunches.data.di.networkModule
import com.test.rocketlaunches.data.di.submodule.apiRepositoryModule
import com.test.rocketlaunches.domain.di.general.dispatcherModules
import com.test.rocketlaunches.domain.di.general.rocketLaunchesUseCaseModule
import com.test.rocketlaunches.home.di.homeModules

val domainModules = listOf(rocketLaunchesUseCaseModule, dispatcherModules)
val dataModules = listOf(networkModule, apiRepositoryModule)
val vmModules = listOf(homeModules)
val testModules = dataModules + domainModules + vmModules