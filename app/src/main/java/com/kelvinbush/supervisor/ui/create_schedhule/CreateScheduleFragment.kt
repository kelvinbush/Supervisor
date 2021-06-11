package com.kelvinbush.supervisor.ui.create_schedhule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelvinbush.supervisor.databinding.CreateScheduleFragmentBinding

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kelvinbush.supervisor.R
import com.kelvinbush.supervisor.adapters.AssignmentsAdapter
import com.kelvinbush.supervisor.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CreateScheduleFragment : Fragment() {

    private var _binding: CreateScheduleFragmentBinding? = null
    private val binding get() = _binding!!
    private val createScheduleViewModel: CreateScheduleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CreateScheduleFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.GONE

        val navController = this@CreateScheduleFragment.findNavController()

        val assignmentsAdapter = AssignmentsAdapter()
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL





        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}