package com.team4.boulderBuild

import android.app.Application
import com.team4.boulderBuild.config.ApplicationDI

class BoulderBuildApp : Application(){

    override fun onCreate() {
        super.onCreate()

        ApplicationDI.initDI(this)
    }
}