package com.team23.room.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.team23.room.data.entities.SettingEntity

@Dao
interface SettingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateSetting(settingEntity: SettingEntity)

    @Query("SELECT value FROM T_SETTING WHERE name = :name")
    fun findValueByName(name: String): String?

    @Query("SELECT value FROM T_SETTING ORDER BY id")
    fun findAllValuesOrderedById(): List<String>
}