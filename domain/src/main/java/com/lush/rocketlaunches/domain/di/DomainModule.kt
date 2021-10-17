package com.lush.rocketlaunches.domain.di

import com.lush.rocketlaunches.domain.di.general.dispatcherModules
import com.lush.rocketlaunches.domain.di.general.rocketLaunchesUseCaseModule

val domainModules = listOf(rocketLaunchesUseCaseModule, dispatcherModules)
