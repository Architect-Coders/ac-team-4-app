package com.team4.usecases


import com.team4.data.repository.GymsRepository
import com.team4.domain.Gym

class FindGymById(private val gymRepository: GymsRepository) {
    suspend fun invoke(id: Int): Gym ?= gymRepository.findGymById(id)
}