package com.test.rocketlaunches.domain.di

import com.test.rocketlaunches.domain.di.general.dispatcherModules
import com.test.rocketlaunches.domain.di.general.rocketLaunchesUseCaseModule

val domainModules = listOf(rocketLaunchesUseCaseModule, dispatcherModules)
