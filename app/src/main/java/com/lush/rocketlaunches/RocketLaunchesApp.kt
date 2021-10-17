package com.lush.rocketlaunches

import android.app.Application
import com.lush.rocketlaunches.data.di.dataModules
import com.lush.rocketlaunches.domain.di.domainModules
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
