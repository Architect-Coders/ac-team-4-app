package com.team4.BoulderBuild.model.data.repository

import com.team4.BoulderBuild.model.data.source.ProblemsLocalDataSource
import com.team4.BoulderBuild.model.domain.Problem

class ProblemsRepository(
    private val ProblemsLocalDataSource: ProblemsLocalDataSource
) {
    suspend fun getAllProblems(): List<Problem> {
        return ProblemsLocalDataSource.getAllProblems()
    }

    suspend fun saveProblems(Problems: List<Problem>) {
        ProblemsLocalDataSource.saveProblems(Problems)
    }

    suspend fun findProblemById(id: Int): Problem? {
        return ProblemsLocalDataSource.findProblemById(id)
    }

    suspend fun update(Problem: Problem) {
        if (Problem.id == null) {
            Problem.id = ProblemCount() // TODO: improve id management
            saveProblems(listOf(Problem))
        } else {
            ProblemsLocalDataSource.update(Problem)
        }
    }

    suspend fun ProblemCount(): Int {
        return ProblemsLocalDataSource.ProblemCount()
    }
}