package com.team4.boulderBuild.model.data.database

import com.team4.boulderBuild.model.data.toDBGym
import com.team4.boulderBuild.model.data.toDomainGym
import com.team4.domain.Gym
import com.team4.data.source.GymsLocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GymsRoomDataSource(db: GymDatabase) : GymsLocalDataSource {

    private val gymDao = db.gymDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { gymDao.gymCount() <= 0 }

    override suspend fun saveGyms(gyms: List<Gym>) {
        withContext(Dispatchers.IO){ gymDao.insertGyms(gyms.map { it.toDBGym() })}
    }

    override suspend fun getAllGyms(): List<Gym>  = withContext(Dispatchers.IO){
        gymDao.getAll().map { it.toDomainGym() }
    }

    override suspend fun findGymById(id: Int): Gym? = withContext(Dispatchers.IO){
        gymDao.findById(id).toDomainGym()
    }

    override suspend fun update(gym: Gym) {
        withContext(Dispatchers.IO){ gymDao.updateGym(gym.toDBGym())}
    }

    override suspend fun gymCount(): Int =
        withContext(Dispatchers.IO){ gymDao.gymCount()}

}