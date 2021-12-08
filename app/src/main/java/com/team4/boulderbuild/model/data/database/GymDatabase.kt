package com.team4.boulderbuild.model.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Gym::class], version = 1)
abstract class GymDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            GymDatabase::class.java,
            "gym-db"
        ).build()
    }

    abstract fun gymDao(): GymDao
}
