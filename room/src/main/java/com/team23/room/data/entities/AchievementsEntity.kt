package com.team23.room.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "T_ACHIEVEMENTS",
    indices = [Index("name")])
data class AchievementsEntity(
    @PrimaryKey
    val name: String,
    val value: Int,
)