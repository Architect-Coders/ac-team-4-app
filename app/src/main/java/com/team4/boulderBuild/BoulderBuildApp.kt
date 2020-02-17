package com.team4.boulderBuild

import android.app.Application

class BoulderBuildApp : Application(){

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}