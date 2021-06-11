package com.kelvinbush.supervisor.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kelvinbush.supervisor.databinding.AssignmentsListItemBinding
import com.kelvinbush.supervisor.domains.Assignment
import com.kelvinbush.supervisor.ui.create_schedhule.CreateScheduleFragment

private const val TAG = "AssignmentsAdapter"

class AssignmentsAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Assignment, AssignmentsAdapter.ViewHolder>(AssignmentsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    interface OnItemClickListener {
        fun onItemClick(assignment: Assignment)
        fun onCheckBoxClick(assignment: Assignment, isChecked: Boolean)
    }

    class ViewHolder private constructor(private val binding: AssignmentsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Assignment) {
            Log.d(TAG, "bind: $item")
            binding.apply {
                assignmentName.text = item.assignmentName
                assignmentCode.text = item.uuid
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = AssignmentsListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

}

class AssignmentsDiffCallBack : DiffUtil.ItemCallback<Assignment>() {
    override fun areItemsTheSame(oldItem: Assignment, newItem: Assignment): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Assignment, newItem: Assignment): Boolean {
        return oldItem.uuid == newItem.uuid
    }

}