package com.team23.room.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "T_SETTINGS",
    indices = [Index("id")])
data class SettingsEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val value: Int,
)
