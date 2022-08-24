package com.team23.room.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.team23.room.data.entities.CategoryEntity

@Dao
interface CategoryDao {
    @Query("SELECT * FROM T_CATEGORY")
    fun loadAll(): List<CategoryEntity>
}