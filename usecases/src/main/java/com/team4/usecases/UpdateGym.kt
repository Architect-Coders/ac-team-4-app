package com.team4.usecases

import com.team4.data.repository.GymsRepository
import com.team4.domain.Gym

class UpdateGym(private val gymsRepository: GymsRepository) {
    suspend fun invoke(gym: Gym): Gym = with(gym) {
        // gymsRepository.update(gym)
        copy().also { gymsRepository.update(it) }
    }
}
