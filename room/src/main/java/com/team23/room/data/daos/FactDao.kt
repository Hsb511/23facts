package com.team23.room.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.team23.room.data.entities.FactEntity

@Dao
interface FactDao {
    @Query("SELECT * FROM T_FACT")
    fun loadAll(): List<FactEntity>

    @Query("SELECT * FROM T_FACT WHERE language = :language AND (content LIKE '%' || :searchText || '%' OR title LIKE '%' || :searchText || '%')")
    fun loadBySearchTextAndLanguage(searchText: String, language: String): List<FactEntity>

    @Query("SELECT * FROM T_FACT WHERE id_fonc = :id AND language = :language")
    fun findByIdAndLanguage(id: Long, language: String): FactEntity?

    @Query("SELECT * FROM T_FACT WHERE code = :category AND language = :language")
    fun findByCategoryAndLanguage(category: String, language: String): List<FactEntity>

    @Query("SELECT * FROM T_FACT WHERE language = :language ORDER BY RANDOM() LIMIT 1")
    fun findRandomByLanguage(language: String): FactEntity?

    @Query("SELECT * FROM T_FACT WHERE language = :language AND isNew = 1 ORDER BY RANDOM() LIMIT 1")
    fun findRandomUnreadByLanguage(language: String): FactEntity?

    @Query("UPDATE T_FACT SET isNew = :isNew WHERE id_fonc = :id")
    fun updateNewById(id: Long, isNew: Boolean = false)

    @Query("SELECT COUNT(*) FROM T_FACT WHERE isNew = 0")
    fun countReadFacts(): Int

    @Query("UPDATE T_FACT SET isNew = 1")
    fun resetData()
}