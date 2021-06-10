package com.kelvinbush.supervisor.ui.home

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kelvinbush.supervisor.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*binding.button.setOnClickListener {
            val checkpoints = arrayListOf<Checkpoint>()
            val checkpoint = Checkpoint(
                0, "Jane Smith", "22",
                "22", "233", State.PENDING, "2nd July 2021"
            )
            val schedule = Schedule(
                0, "John Doe", "JKUAT",
                "KCB 232E", LocalDate.now().toString(), LocalDate.now().toString()
            )
            checkpoints.add(checkpoint)
            homeViewModel.saveExampleSchedule(schedule, checkpoints)
        }*/
        /*homeViewModel.getData().observe(viewLifecycleOwner, {
            var text = ""
            it.forEach { schedule -> text += schedule.toString() }
            binding.textView.text = text
            Log.d("onCreateView: ", text)
        })*/

        Log.d(TAG, "onCreateView: called")



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}