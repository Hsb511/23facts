package com.team23.room.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "T_FORM",
    primaryKeys = ["id_fonc", "language"],
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["code"],
        childColumns = ["code"]
    )],
    indices = [Index(value = ["id_fonc", "language"]), Index(value = ["code"])]
)
data class FactEntity(
    val id_fonc: Long,
    val language: String,
    val code: String,
    val image: String,
    val content: String,
    val links: String
)