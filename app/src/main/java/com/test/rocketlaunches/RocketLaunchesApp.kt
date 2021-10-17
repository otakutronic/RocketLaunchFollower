package com.test.rocketlaunches

import android.app.Application
import com.test.rocketlaunches.data.di.dataModules
import com.test.rocketlaunches.domain.di.domainModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RocketLaunchesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RocketLaunchesApp)
            modules(dataModules + domainModules)
        }
    }
}
