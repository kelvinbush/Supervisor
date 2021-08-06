package com.kelvinbush.supervisor.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Schedule(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val supervisorName: String,
    val region: String,
    val vehicleRegNo: String,
//    val route: String,
    val startDate: String,
    var endDate: String
)



