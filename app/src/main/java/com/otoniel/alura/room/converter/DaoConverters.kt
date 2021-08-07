package com.otoniel.alura.room.converter

import androidx.room.TypeConverter
import java.util.Date

class DaoConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}