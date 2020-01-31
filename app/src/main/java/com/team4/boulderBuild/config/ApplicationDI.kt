package com.team4.boulderBuild.config

import android.content.Context
import com.team4.boulderBuild.model.data.database.GymDatabase
import com.team4.data.repository.GymsRepository
import com.team4.boulderBuild.model.data.source.GymsRoomDataSource

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