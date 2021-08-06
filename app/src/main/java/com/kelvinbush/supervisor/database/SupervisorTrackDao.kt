package com.kelvinbush.supervisor.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface SupervisorTrackDao {

    @Insert
    suspend fun addNewCheckpoints(checkpoints: List<Checkpoint>)

    @Update
    suspend fun updateAssignmentChecked(assignment: Assignment)

    @Insert
    suspend fun addAssignment(assignment: Assignment);

    @Insert
    suspend fun addNewSchedule(schedule: Schedule)

    @Insert
    suspend fun insertAllAssignments(assignments: List<Assignment>)


    @Transaction
    suspend fun addNewScheduleWithCheckpoints(schedule: Schedule, checkpoints: List<Checkpoint>) {
        addNewSchedule(schedule)
        addNewCheckpoints(checkpoints)
    }

    @Transaction
    @Query("select * from assignment where region = :region order by id")
    fun getAllAssignments(region: String): Flow<List<Assignment>>

    @Transaction
    @Query("SELECT * FROM schedule ORDER BY id")
    fun getAllSchedulesWithCheckpoints(): List<ScheduleWithCheckpoints>

}