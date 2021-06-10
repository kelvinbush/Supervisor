package com.kelvinbush.supervisor.ui.pick_assignments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kelvinbush.supervisor.R
import com.kelvinbush.supervisor.databinding.PickAssignmentsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PickAssignmentsFragment : Fragment() {

    private var _binding: PickAssignmentsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PickAssignmentsFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}