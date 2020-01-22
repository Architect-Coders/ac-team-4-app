package com.team4.BoulderBuild.model.data.database

import androidx.room.TypeConverter
import com.team4.BoulderBuild.model.domain.enums.Grade
import java.util.*

class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromGradeToString(grade: Grade?) = grade?.toString()


    @TypeConverter
    fun fromStringToGrade(grade: String?) = grade?.let(Grade::valueOf)
    

}