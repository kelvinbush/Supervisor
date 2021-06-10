package com.kelvinbush.supervisor.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Checkpoint(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val assignmentName: String,
    val latitude: String,
    val longitude: String,
    val radius: String,
    val state: State,
    val date: String
)