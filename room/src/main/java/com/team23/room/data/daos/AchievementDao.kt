package com.team23.room.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.team23.room.data.entities.AchievementEntity

@Dao
interface AchievementDao {
    @Query("SELECT * FROM T_ACHIEVEMENT")
    fun loadAll(): List<AchievementEntity>

    @Query("UPDATE T_ACHIEVEMENT SET isFound = 1 WHERE name = :achievementName")
    fun updateIsFound(achievementName: String)
}