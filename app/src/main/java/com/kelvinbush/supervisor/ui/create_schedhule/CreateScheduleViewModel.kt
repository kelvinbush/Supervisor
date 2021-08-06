package com.kelvinbush.supervisor.ui.create_schedhule

import android.util.Log
import androidx.lifecycle.*
import com.kelvinbush.supervisor.database.Assignment
import com.kelvinbush.supervisor.repo.SupervisorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "CreateScheduleViewModel"

@HiltViewModel
class CreateScheduleViewModel @Inject constructor(
    private val repository: SupervisorRepository
) : ViewModel() {

    private var _regions = MutableLiveData<List<Assignment>>()

    val regions: LiveData<List<Assignment>>
        get() = _regions


    fun updateAssignments(assignment: Assignment, isChecked: Boolean) = viewModelScope.launch {
        repository.updateAssignment(assignment.copy(isChosen = isChecked))
    }

    fun getAssignments(region: String): LiveData<List<Assignment>> {
        return repository.getRegionsWithAssignments(region).asLiveData()
    }

    fun addAssignment(assignment: Assignment) = viewModelScope.launch {
        repository.addAssignment(assignment)
    }

    fun insertAllAssignments(assignments: List<Assignment>) = viewModelScope.launch {
        repository.insertAll(assignments)
    }

}