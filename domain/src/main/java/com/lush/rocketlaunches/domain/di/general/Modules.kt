package com.lush.rocketlaunches.domain.di.general

import com.lush.rocketlaunches.domain.usecase.GetRocketLaunchesUseCase
import com.lush.rocketlaunches.domain.widget.DefaultDispatcherProvider
import com.lush.rocketlaunches.domain.widget.DispatcherProvider
import org.koin.dsl.module

val rocketLaunchesUseCaseModule = module(override = true) {
    single { GetRocketLaunchesUseCase(get()) }
}

val dispatcherModules = module {
    factory<DispatcherProvider> { DefaultDispatcherProvider() }
}
