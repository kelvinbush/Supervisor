package com.kelvinbush.supervisor.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Assignment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val uuid: String,
//    val longitude: String,
//    val latitude: String,
//    val geofenceRadius: String,
    val assignmentName: String,
    val isChosen: Boolean = false,
    val region: String
)