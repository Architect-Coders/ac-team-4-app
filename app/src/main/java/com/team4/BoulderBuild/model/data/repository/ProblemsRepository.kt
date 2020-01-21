package com.team4.BoulderBuild.model.data.repository

import com.team4.BoulderBuild.model.data.source.ProblemsLocalDataSource
import com.team4.BoulderBuild.model.domain.Problem

class ProblemsRepository(
    private val problemsLocalDataSource: ProblemsLocalDataSource
) {
    suspend fun getAllProblems(): List<Problem> {
        return problemsLocalDataSource.getAllProblems()
    }

    suspend fun saveProblems(Problems: List<Problem>) {
        problemsLocalDataSource.saveProblems(Problems)
    }

    suspend fun findProblemById(id: Int): Problem? {
        return problemsLocalDataSource.findProblemById(id)
    }

    suspend fun update(Problem: Problem) {
        if (Problem.id == null) {
            Problem.id = problemCount() // TODO: improve id management
            saveProblems(listOf(Problem))
        } else {
            problemsLocalDataSource.update(Problem)
        }
    }

    suspend fun problemCount(): Int {
        return problemsLocalDataSource.problemCount()
    }
}