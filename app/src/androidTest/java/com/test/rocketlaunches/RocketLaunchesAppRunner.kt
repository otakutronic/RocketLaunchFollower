package com.test.rocketlaunches

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class RocketLaunchesAppRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, RocketLaunchesApp::class.java.name, context)
    }
}
