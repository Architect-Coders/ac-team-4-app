package com.team4.BoulderBuild.model.data.database

import androidx.room.*

@Dao
interface ProblemDao {
    @Query("SELECT * FROM Problem")
    fun getAll(): List<Problem>

    @Query("SELECT * FROM Problem WHERE gymId = :gymId")
    fun getProblemsByGym(gymId: Int): List<Problem>

    @Query("SELECT * FROM Problem WHERE id = :id")
    fun findById(id: Int): Problem

    @Query("SELECT COUNT(id) FROM Problem")
    fun problemCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProblems(Problems: List<Problem>)

    @Update
    fun updateProblem(Problem: Problem)
}