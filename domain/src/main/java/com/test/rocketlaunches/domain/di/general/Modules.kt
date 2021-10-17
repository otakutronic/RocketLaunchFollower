package com.test.rocketlaunches.domain.di.general

import com.test.rocketlaunches.domain.usecase.GetRocketLaunchesUseCase
import com.test.rocketlaunches.domain.widget.DefaultDispatcherProvider
import com.test.rocketlaunches.domain.widget.DispatcherProvider
import org.koin.dsl.module

val rocketLaunchesUseCaseModule = module(override = true) {
    single { GetRocketLaunchesUseCase(get()) }
}

val dispatcherModules = module {
    factory<DispatcherProvider> { DefaultDispatcherProvider() }
}
