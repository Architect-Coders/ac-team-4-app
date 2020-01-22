package com.team4.BoulderBuild.model.data.source

import com.team4.BoulderBuild.model.domain.Problem

interface ProblemsLocalDataSource {
    suspend fun saveProblems(problems: List<Problem>)
    suspend fun getAllProblems(): List<Problem>
    suspend fun getProblemsByGym(gymId: Int): List<Problem>
    suspend fun findProblemById(id: Int): Problem?
    suspend fun update(problem: Problem)
    suspend fun problemCount(): Int
}