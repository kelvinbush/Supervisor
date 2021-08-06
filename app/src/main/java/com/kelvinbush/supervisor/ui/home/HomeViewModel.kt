package com.kelvinbush.supervisor.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.kelvinbush.supervisor.database.Checkpoint
import com.kelvinbush.supervisor.database.Schedule
import com.kelvinbush.supervisor.database.ScheduleWithCheckpoints
import com.kelvinbush.supervisor.repo.SupervisorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SupervisorRepository
) : ViewModel() {

    private val TAG = "HomeViewModel"

//    init {
//        getData()
//
//    }

    /*fun getData(): LiveData<List<ScheduleWithCheckpoints>> {
        Log.d(TAG, "INIT: Called")
        return repository.allSchedules.asLiveData()
    }*/

    fun saveExampleSchedule(schedule: Schedule, checkpoints: List<Checkpoint>) {
        Log.d(TAG, "saveExampleSchedule: called")
        viewModelScope.launch {
            repository.addNewScheduleWithCheckPoints(schedule, checkpoints)
        }
    }
}