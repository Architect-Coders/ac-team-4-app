package com.team4.BoulderBuild

import android.app.Application
import com.team4.BoulderBuild.config.ApplicationDI
import com.team4.BoulderBuild.model.data.database.GymDatabase
import com.team4.BoulderBuild.model.data.repository.GymsRepository
import com.team4.BoulderBuild.model.data.source.GymsRoomDataSource

class BoulderBuildApp : Application(){

    override fun onCreate() {
        super.onCreate()

        ApplicationDI.initDI(this)
    }
}