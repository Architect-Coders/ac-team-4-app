package com.team4.BoulderBuild.config

import android.content.Context
import com.team4.BoulderBuild.model.data.database.GymDatabase
import com.team4.BoulderBuild.model.data.repository.GymsRepository
import com.team4.BoulderBuild.model.data.source.GymsLocalDataSource
import com.team4.BoulderBuild.model.data.source.GymsRoomDataSource

object ApplicationDI{
    // TODO: use Koin in the future

    private var context : Context? = null
    private var gymsRepository : GymsRepository? = null

    fun initDI(context: Context){
        this.context = context
        gymsRepository = GymsRepository(GymsRoomDataSource(GymDatabase.buildDatabase(context)))
    }

    fun getGymsRepository(): GymsRepository?{
        return gymsRepository
    }
}