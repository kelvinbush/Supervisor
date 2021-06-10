package com.kelvinbush.supervisor.database

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun toHealth(value: String) = enumValueOf<State>(value)

    @TypeConverter
    fun fromHealth(value: State) = value.name

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}

