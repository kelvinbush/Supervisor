package com.kelvinbush.supervisor.database

import androidx.room.Embedded
import androidx.room.Relation

data class ScheduleWithCheckpoints(
    @Embedded val schedule: Schedule,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val checkpoints: List<Checkpoint>
)