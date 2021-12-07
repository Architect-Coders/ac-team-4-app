package com.team4.boulderbuild.model.data.database

import androidx.room.*

@Dao
interface GymDao {
    @Query("SELECT * FROM Gym")
    fun getAll(): List<Gym>

    @Query("SELECT * FROM Gym WHERE id = :id")
    fun findById(id: Int): Gym

    @Query("SELECT COUNT(id) FROM Gym")
    fun gymCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGyms(gyms: List<Gym>)

    @Update
    fun updateGym(gym: Gym)
}