package com.team4.BoulderBuild.config

import android.content.Context
import com.team4.BoulderBuild.model.data.database.GymDatabase
import com.team4.BoulderBuild.model.data.repository.GymsRepository
import com.team4.BoulderBuild.model.data.repository.ProblemsRepository
import com.team4.BoulderBuild.model.data.source.GymsRoomDataSource
import com.team4.BoulderBuild.model.data.source.ProblemsRoomDataSource

object ApplicationDI {
    // TODO: use Koin in the future

    private var context: Context? = null
    private lateinit var gymsRepository: GymsRepository
    private lateinit var problemsRepository: ProblemsRepository

    fun initDI(context: Context) {
        this.context = context
        gymsRepository = GymsRepository(GymsRoomDataSource(GymDatabase.buildDatabase(context)))
        problemsRepository =
            ProblemsRepository(ProblemsRoomDataSource(GymDatabase.buildDatabase(context)))
    }

    fun getGymsRepository(): GymsRepository {
        return gymsRepository
    }

    fun getProblemsRepository(): ProblemsRepository {
        return problemsRepository
    }
}