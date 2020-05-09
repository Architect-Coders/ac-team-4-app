package com.team4.data.source


import com.team4.domain.Gym

interface GymsRemoteDataSource {
    suspend fun getAllGyms(apiKey: String, region: String): List<Gym>
}