package com.kelvinbush.supervisor.ui.create_schedhule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kelvinbush.supervisor.databinding.CreateScheduleFragmentBinding

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kelvinbush.supervisor.R


class CreateScheduleFragment : Fragment() {

    private var _binding: CreateScheduleFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CreateScheduleFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = View.GONE

        val navController = this@CreateScheduleFragment.findNavController()
//        val includedView: View = binding
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}