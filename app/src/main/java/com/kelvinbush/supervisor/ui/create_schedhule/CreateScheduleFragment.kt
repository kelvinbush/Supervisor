package com.kelvinbush.supervisor.ui.create_schedhule

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelvinbush.supervisor.databinding.CreateScheduleFragmentBinding

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kelvinbush.supervisor.R
import com.kelvinbush.supervisor.adapters.AssignmentsAdapter
import com.kelvinbush.supervisor.database.Assignment
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

private const val TAG = "CreateScheduleFragment"

enum class Region {
    JKUAT,
    KU,
    KAHAWA
}

@AndroidEntryPoint
class CreateScheduleFragment : Fragment(R.layout.create_schedule_fragment),
    AdapterView.OnItemSelectedListener, AssignmentsAdapter.OnItemClickListener {

    private var _binding: CreateScheduleFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CreateScheduleViewModel by viewModels()
    private var arrayAdapter: ArrayAdapter<String>? = null
    private val allRegions = mutableSetOf<String>()
    private var assignments: List<Assignment>? = null
    private val assignmentsAdapter = AssignmentsAdapter(this@CreateScheduleFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CreateScheduleFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.GONE
        Log.d(TAG, "onCreateView: called")
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerViewTasks.layoutManager = layoutManager
        binding.recyclerViewTasks.adapter = assignmentsAdapter
        binding.recyclerViewTasks.itemAnimator = null

        binding.routeSpinner.onItemSelectedListener = this@CreateScheduleFragment
        arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            arrayListOf(Region.KAHAWA.toString(), Region.JKUAT.toString(), Region.KU.toString())
        )
        binding.routeSpinner.adapter = arrayAdapter

        getCheckBoxValues()
        initializeDb()


        return root
    }

    private fun getCheckBoxValues() {

    }

    private fun initializeDb() {
        val assignmentList = arrayListOf(
            Assignment(assignmentName = "Main Gate", region = Region.JKUAT.toString()),
            Assignment(assignmentName = "Jkuat Hospital", region = Region.JKUAT.toString()),
            Assignment(assignmentName = "Technology House", region = Region.JKUAT.toString()),
            Assignment(assignmentName = "Chandaria House", region = Region.KU.toString()),
            Assignment(assignmentName = "Chancellor's Towers", region = Region.KU.toString()),
            Assignment(assignmentName = "Teaching hospital", region = Region.KU.toString()),
            Assignment(assignmentName = "QuickMart", region = Region.KAHAWA.toString()),
            Assignment(assignmentName = "MetroMart", region = Region.KAHAWA.toString()),
            Assignment(assignmentName = "Seven Eleven", region = Region.KAHAWA.toString())
        )
        viewModel.insertAllAssignments(assignmentList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.getAssignments(binding.routeSpinner.selectedItem.toString())
            .observe(viewLifecycleOwner, {

                assignmentsAdapter.submitList(it)
            })
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(assignment: Assignment) {
        TODO("Not yet implemented")
    }

    override fun onCheckBoxClicked(assignment: Assignment, isChecked: Boolean) {
        viewModel.updateAssignments(assignment, isChecked)
    }
}