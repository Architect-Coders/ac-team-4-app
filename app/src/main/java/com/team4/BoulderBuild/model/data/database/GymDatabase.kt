package com.team4.BoulderBuild.model.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Gym::class, Problem::class], version = 2)
@TypeConverters(Converters::class)
abstract class GymDatabase : RoomDatabase() {

    companion object {
        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            GymDatabase::class.java,
            "gym-db"
        ).build()
    }

    abstract fun gymDao(): GymDao

    abstract fun problemDao(): ProblemDao
}