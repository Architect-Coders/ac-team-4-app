package com.team4.BoulderBuild.model.domain

import com.team4.BoulderBuild.model.domain.enums.Grade

data class Problem(
    var id: Int?,
    val description: String?,
    val grade: Grade?,
    val imgSrc: String?
)

