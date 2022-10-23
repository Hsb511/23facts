package com.team23.room.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "T_CATEGORY",
        indices = [Index("code")])
data class CategoryEntity(
    @PrimaryKey
    val code: String,
    val name_en: String,
    val name_fr: String,
    val short_name_en: String,
    val short_name_fr: String,
)
