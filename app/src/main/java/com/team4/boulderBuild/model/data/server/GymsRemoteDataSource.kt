package com.team4.boulderBuild.model.data.server

import com.team4.data.source.GymsRemoteDataSource
import com.team4.domain.Gym

class GymsRemoteDataSourceFake : GymsRemoteDataSource {
    override suspend fun getAllGyms(apiKey: String, region: String): List<Gym> {
        return listOf(
            Gym(1, "Area 51 Boulder", "Descripción", 4.0, 1.4, ""),
            Gym(2, "The Factory", "Descripción 2", 4.0, 1.3, ""),
            Gym(3, "The Roof", "Descripción 3", 4.0, 1.2, ""))
    }
}