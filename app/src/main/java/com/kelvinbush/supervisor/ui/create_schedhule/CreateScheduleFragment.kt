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
import com.kelvinbush.supervisor.domains.Region
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CreateScheduleFragment : Fragment(),
    AdapterView.OnItemSelectedListener {

    private var _binding: CreateScheduleFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CreateScheduleViewModel by viewModels()
    private var arrayAdapter: ArrayAdapter<String>? = null
    private val allRegions = arrayListOf<String>()
    private var assignmentRegions: List<Region>? = null
    private val assignmentsAdapter = AssignmentsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CreateScheduleFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.GONE

        val navController = this@CreateScheduleFragment.findNavController()

//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        navController.navigateUp(appBarConfiguration)

        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        binding.routeSpinner.onItemSelectedListener = this@CreateScheduleFragment

        viewModel.regions.observe(viewLifecycleOwner, {
            if (allRegions.isEmpty()) {
                it.forEach { region ->
                    allRegions.add(region.name)
                }
            }
            arrayAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                allRegions
            )
            binding.routeSpinner.adapter = arrayAdapter
            assignmentRegions = it
            Log.d("TAG", "onCreateView: $it")

        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        getAssignmentsForRegion(position)
    }

    private fun getAssignmentsForRegion(i: Int) {
        assignmentsAdapter.submitList(assignmentRegions?.get(i)?.assignments)

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}