package com.kelvinbush.supervisor.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kelvinbush.supervisor.databinding.AssignmentsListItemBinding
import com.kelvinbush.supervisor.database.Assignment


private const val TAG = "AssignmentsAdapter"

class AssignmentsAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Assignment, AssignmentsAdapter.AssignmentsViewHolder>(AssignmentsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentsViewHolder {
        val binding =
            AssignmentsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AssignmentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssignmentsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    interface OnItemClickListener {
        fun onItemClick(assignment: Assignment)
        fun onCheckBoxClicked(assignment: Assignment, isChecked: Boolean)
    }

    inner class AssignmentsViewHolder(private val binding: AssignmentsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = absoluteAdapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val assignment = getItem(position)
                        listener.onItemClick(assignment)
                    }
                }

                checkBox.setOnClickListener {
                    val position = absoluteAdapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val assignment = getItem(position)
                        listener.onCheckBoxClicked(assignment, checkBox.isChecked)
                    }
                }
            }
        }


        fun bind(item: Assignment) {
            Log.d(TAG, "bind: $item")
            binding.apply {
                assignmentName.text = item.assignmentName
                assignmentCode.text = item.id.toString()
                checkBox.isChecked = item.isChosen
            }
        }

    }

}

class AssignmentsDiffCallBack : DiffUtil.ItemCallback<Assignment>() {
    override fun areItemsTheSame(oldItem: Assignment, newItem: Assignment): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Assignment, newItem: Assignment): Boolean {
        return oldItem.id == newItem.id
    }

}