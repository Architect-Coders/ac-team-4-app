package com.team4.BoulderBuild

import android.app.Application
import com.team4.BoulderBuild.config.ApplicationDI

class BoulderBuildApp : Application(){

    override fun onCreate() {
        super.onCreate()

        ApplicationDI.initDI(this)
    }
}