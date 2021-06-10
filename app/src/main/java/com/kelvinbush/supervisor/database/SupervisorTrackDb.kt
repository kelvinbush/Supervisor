package com.kelvinbush.supervisor.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Schedule::class, Checkpoint::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SupervisorTrackDb : RoomDatabase() {

    abstract fun getSupervisorDao(): SupervisorTrackDao
}