package com.team4.BoulderBuild.model.data.mappers

import com.team4.BoulderBuild.model.domain.enums.Grade
import com.team4.BoulderBuild.model.data.database.Problem as DBProblem
import com.team4.BoulderBuild.model.domain.Problem as DomainProblem

fun DomainProblem.toDBProblem(): DBProblem =
    DBProblem(
        id ?: -1,
        description ?: "",
        grade ?: Grade.NORMAL,
        imgSrc ?: ""
    )

fun DBProblem.toDomainProblem(): DomainProblem =
    DomainProblem(
        id,
        description,
        grade,
        imgSrc
    )