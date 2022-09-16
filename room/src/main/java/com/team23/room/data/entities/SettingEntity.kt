package com.team23.room.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "T_SETTING",
    indices = [Index("id")])
data class SettingEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val value: Int,
)
