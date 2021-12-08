package com.team4.boulderbuild

import android.app.Application

class BoulderBuildApp : Application(){

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}
