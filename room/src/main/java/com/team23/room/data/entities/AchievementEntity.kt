package com.team23.room.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "T_ACHIEVEMENT",
    indices = [Index("name")])
data class AchievementEntity(
    @PrimaryKey
    val name: String,
    val isFound: Boolean,
)