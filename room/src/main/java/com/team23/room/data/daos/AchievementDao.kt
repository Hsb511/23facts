package com.team23.room.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.team23.room.data.entities.AchievementEntity
import java.util.*

@Dao
interface AchievementDao {
    @Query("SELECT * FROM T_ACHIEVEMENT")
    fun loadAll(): List<AchievementEntity>

    @Query("SELECT isFound FROM T_ACHIEVEMENT WHERE name = :name")
    fun findIsFoundByName(name: String): Boolean

    @Query("UPDATE T_ACHIEVEMENT SET isFound = 1, unlockedDate = :date WHERE name = :achievementName")
    fun updateIsFoundAndUnlockDate(achievementName: String, date: Date)
}