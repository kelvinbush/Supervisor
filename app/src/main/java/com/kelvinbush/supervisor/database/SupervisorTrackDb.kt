package com.kelvinbush.supervisor.database


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Schedule::class, Checkpoint::class, Assignment::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class SupervisorTrackDb : RoomDatabase() {

    abstract fun getSupervisorDao(): SupervisorTrackDao
}