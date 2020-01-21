package com.team4.BoulderBuild.model.data.source

import com.team4.BoulderBuild.model.data.database.GymDatabase
import com.team4.BoulderBuild.model.data.mappers.toDBProblem
import com.team4.BoulderBuild.model.data.mappers.toDomainProblem
import com.team4.BoulderBuild.model.domain.Problem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProblemsRoomDataSource(db: GymDatabase) : ProblemsLocalDataSource {

    private val problemDao = db.problemDao()

    override suspend fun saveProblems(Problems: List<Problem>) {
        withContext(Dispatchers.IO) { problemDao.insertProblems(Problems.map { it.toDBProblem() }) }
    }

    override suspend fun getAllProblems(): List<Problem> = withContext(Dispatchers.IO) {
        problemDao.getAll().map { it.toDomainProblem() }
    }

    override suspend fun findProblemById(id: Int): Problem? = withContext(Dispatchers.IO) {
        problemDao.findById(id).toDomainProblem()
    }

    override suspend fun update(Problem: Problem) {
        withContext(Dispatchers.IO) { problemDao.updateProblem(Problem.toDBProblem()) }
    }

    override suspend fun problemCount(): Int =
        withContext(Dispatchers.IO) { problemDao.problemCount() }

}