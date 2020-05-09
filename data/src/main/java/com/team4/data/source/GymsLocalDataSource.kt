package com.team4.data.source

import com.team4.domain.Gym

interface GymsLocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveGyms(gyms : List<Gym>)
    suspend fun getAllGyms() : List<Gym>
    suspend fun findGymById(id: Int) : Gym?
    suspend fun update(gym: Gym)
    suspend fun gymCount() : Int
}