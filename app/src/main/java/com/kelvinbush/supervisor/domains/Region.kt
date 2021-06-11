package com.kelvinbush.supervisor.domains

data class Region(
    val id: Int,
    val name: String,
    val assignments: List<Assignment>
)

data class Assignment(
    val uuid: String,
    val longitude: String,
    val latitude: String,
    val geofenceRadius: String,
    val assignmentName: String,
    val isChecked: Boolean
)