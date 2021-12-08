package com.team4.usecases

import com.team4.data.repository.GymsRepository
import com.team4.domain.Gym

class GetAllGyms(private val gymRepository: GymsRepository) {
    suspend fun invoke(): List<Gym> {
        return gymRepository.getAllGyms()
    }
}
