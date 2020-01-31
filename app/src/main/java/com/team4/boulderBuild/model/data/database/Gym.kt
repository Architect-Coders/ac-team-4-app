package com.team4.boulderBuild.model.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gym (
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val description: String,
    val lat : Double,
    val lon : Double,
    val imgSrc : String
)