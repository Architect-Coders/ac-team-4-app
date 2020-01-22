package com.team4.BoulderBuild.model.data.repository

import com.team4.BoulderBuild.model.data.source.ProblemsLocalDataSource
import com.team4.BoulderBuild.model.domain.Problem

class ProblemsRepository(
    private val problemsLocalDataSource: ProblemsLocalDataSource
) {
    suspend fun getAllProblems(): List<Problem> {
        return problemsLocalDataSource.getAllProblems()
    }

    suspend fun getProblemsByGym(gymId: Int): List<Problem> {
        return problemsLocalDataSource.getProblemsByGym(gymId)
    }


    suspend fun saveProblems(Problems: List<Problem>) {
        problemsLocalDataSource.saveProblems(Problems)
    }

    suspend fun findProblemById(id: Int): Problem? {
        return problemsLocalDataSource.findProblemById(id)
    }

    suspend fun update(problem: Problem) {
        if (problem.id == null) {
            problem.id = problemCount() // TODO: improve id management
            saveProblems(listOf(problem))
        } else {
            problemsLocalDataSource.update(problem)
        }
    }

    suspend fun problemCount(): Int {
        return problemsLocalDataSource.problemCount()
    }
}