package com.team23.room.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.team23.room.data.entities.FactEntity

@Dao
interface FactDao {
    @Query("SELECT * FROM T_FACT")
    fun loadAll(): List<FactEntity>

    @Query("SELECT * FROM T_FACT WHERE id_fonc = :id AND language = :language")
    fun findById(id: Long, language: String): FactEntity?
}