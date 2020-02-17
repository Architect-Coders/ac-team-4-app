package com.team4.boulderBuild.model.data.server

import com.team4.data.source.GymsRemoteDataSource
import com.team4.domain.Gym

class GymsRemoteDataSourceFake : GymsRemoteDataSource {
    override suspend fun getAllGyms(apiKey: String, region: String): List<Gym> {
        var g = Gym(1, "nombre", "descripcion", 1.0, 1.1, "imagen")
        return mutableListOf<Gym>(g)
    }
}