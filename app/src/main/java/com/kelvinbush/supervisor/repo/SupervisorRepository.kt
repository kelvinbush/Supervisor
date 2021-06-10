package com.kelvinbush.supervisor.repo

import androidx.annotation.WorkerThread
import com.kelvinbush.supervisor.database.Checkpoint
import com.kelvinbush.supervisor.database.Schedule
import com.kelvinbush.supervisor.database.SupervisorTrackDao
import com.kelvinbush.supervisor.domains.Assignment
import com.kelvinbush.supervisor.domains.Region
import javax.inject.Inject

class SupervisorRepository @Inject constructor(
    private val supervisorTrackDao: SupervisorTrackDao
) {

    val allSchedules = supervisorTrackDao.getAllSchedulesWithCheckpoints()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addNewScheduleWithCheckPoints(schedule: Schedule, checkpoints: List<Checkpoint>) {
        supervisorTrackDao.addNewScheduleWithCheckpoints(schedule, checkpoints)
    }

    fun getRegionsWithAssignments(): List<Region> {
        val assignments = arrayListOf<Assignment>()
        val assignment1 = Assignment("2234", "37.0154", "-1.0969", "50", "gatea")
        val assignment2 = Assignment("7833", "36.9318", "-1.1876", "50", "maingate")
        val assignment3 = Assignment("3333", "36.962167", "-0.395584", "50", "dekutmaingate")
        assignments.add(assignment1)
        assignments.add(assignment3)
        return arrayListOf(
            Region(1, "JKUAT", assignments),
            Region(2, "KU", arrayListOf(assignment2))
        )
    }
}