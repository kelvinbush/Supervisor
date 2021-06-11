package com.kelvinbush.supervisor.ui.create_schedhule

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kelvinbush.supervisor.domains.Region
import com.kelvinbush.supervisor.repo.SupervisorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


private const val TAG = "CreateScheduleViewModel"

@HiltViewModel
class CreateScheduleViewModel @Inject constructor(
    private val repository: SupervisorRepository
) : ViewModel() {

    private var _regions = MutableLiveData<List<Region>>()

    val regions:LiveData<List<Region>>
        get() = _regions

    init {
        getRegions()
    }

    private fun getRegions() {
        Log.d(TAG, "getRegions: called")
        _regions.value = repository.getRegionsWithAssignments()
    }

}