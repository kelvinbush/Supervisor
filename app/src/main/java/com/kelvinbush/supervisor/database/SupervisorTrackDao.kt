package com.kelvinbush.supervisor.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface SupervisorTrackDao {

    @Insert
    suspend fun addNewCheckpoints(checkpoints: List<Checkpoint>)

    @Insert
    suspend fun addNewSchedule(schedule: Schedule)

    @Transaction
    suspend fun addNewScheduleWithCheckpoints(schedule: Schedule, checkpoints: List<Checkpoint>) {
        addNewSchedule(schedule)
        addNewCheckpoints(checkpoints)
    }

    @Transaction
    @Query("SELECT * FROM schedule ORDER BY id DESC")
    fun getAllSchedulesWithCheckpoints(): Flow<List<ScheduleWithCheckpoints>>

}