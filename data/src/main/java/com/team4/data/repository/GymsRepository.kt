package com.team4.data.repository

import com.team4.data.source.GymsLocalDataSource
import com.team4.domain.Gym

class GymsRepository(
    private val gymsLocalDataSource: GymsLocalDataSource
) {
    suspend fun getAllGyms(): List<Gym> {
        return gymsLocalDataSource.getAllGyms()
    }

    suspend fun saveGyms(gyms: List<Gym>) {
        gymsLocalDataSource.saveGyms(gyms)
    }

    suspend fun findGymById(id: Int): Gym? {
        return gymsLocalDataSource.findGymById(id)
    }

    suspend fun update(gym: Gym) {
        if (gym.id == null) {
            // gym.id = gymCount() // TODO: improve id management
            saveGyms(listOf(gym))
        } else {
            gymsLocalDataSource.update(gym)
        }
    }

    suspend fun gymCount(): Int {
        return gymsLocalDataSource.gymCount()
    }
}