package com.team4.BoulderBuild.model.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Problem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val description: String,
    val grade: Int,
    val imgSrc: String
)