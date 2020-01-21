package com.team4.BoulderBuild.model.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.team4.BoulderBuild.model.domain.enums.Grade

@Entity
data class Problem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val description: String,
    val grade: Grade,
    val imgSrc: String
)