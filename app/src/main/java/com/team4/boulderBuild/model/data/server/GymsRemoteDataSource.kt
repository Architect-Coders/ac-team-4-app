package com.team4.boulderBuild.model.data.server

import com.team4.data.source.GymsRemoteDataSource
import com.team4.domain.Gym

class GymsRemoteDataSourceFake : GymsRemoteDataSource {
    override suspend fun getAllGyms(apiKey: String, region: String): List<Gym> {
        return mutableListOf(Gym(1, "nombre", "descripcion", 1.0, 1.1, "imagen"),
            Gym(2, "nombre2", "descripcion2", 1.0, 1.1, "imagen"),
            Gym(3, "nombre3", "descripcion3", 1.0, 1.1, "imagen"))
    }
}