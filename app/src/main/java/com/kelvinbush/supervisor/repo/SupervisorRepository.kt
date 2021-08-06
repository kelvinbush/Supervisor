package com.kelvinbush.supervisor.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.asLiveData
import com.kelvinbush.supervisor.database.Checkpoint
import com.kelvinbush.supervisor.database.Schedule
import com.kelvinbush.supervisor.database.SupervisorTrackDao
import com.kelvinbush.supervisor.database.Assignment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

class SupervisorRepository @Inject constructor(
    private val supervisorTrackDao: SupervisorTrackDao
) {

//    val allSchedules = supervisorTrackDao.getAllSchedulesWithCheckpoints()
//    val allAssignments = supervisorTrackDao.getAllAssignments()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addNewScheduleWithCheckPoints(schedule: Schedule, checkpoints: List<Checkpoint>) {
        supervisorTrackDao.addNewScheduleWithCheckpoints(schedule, checkpoints)
    }

    suspend fun updateAssignment(assignment: Assignment) {
        supervisorTrackDao.updateAssignmentChecked(assignment)
    }

    suspend fun addAssignment(assignment: Assignment) {
        supervisorTrackDao.addAssignment(assignment)
    }

    suspend fun insertAll(assignments: List<Assignment>) {
        supervisorTrackDao.insertAllAssignments(assignments)
    }

    @WorkerThread
    fun getRegionsWithAssignments(region: String): Flow<List<Assignment>> {

        return supervisorTrackDao.getAllAssignments(region)
        /*val assignments = arrayListOf<Assignment>()
        val assignment1 = Assignment(0, "37.0154", "-1.0969", "50", "gatea", false)
        val assignment2 = Assignment(0, "36.9318", "-1.1876", "50", "maingate", false)
        val assignment3 = Assignment(0, "36.962167", "-0.395584", "50", "dekutmaingate", false)
        assignments.add(assignment1)
        assignments.add(assignment3)
        return arrayListOf(
            Region(1, "JKUAT", assignments),
            Region(2, "KU", arrayListOf(assignment2))
        )*/
    }
}