package com.team23.room.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.team23.room.data.AppDatabase.Companion.BDD_VERSION
import com.team23.room.data.converters.DateConverter
import com.team23.room.data.daos.AchievementDao
import com.team23.room.data.daos.CategoryDao
import com.team23.room.data.daos.FactDao
import com.team23.room.data.daos.SettingDao
import com.team23.room.data.entities.AchievementEntity
import com.team23.room.data.entities.CategoryEntity
import com.team23.room.data.entities.FactEntity
import com.team23.room.data.entities.SettingEntity

@Database(
    entities = [AchievementEntity::class, FactEntity::class, CategoryEntity::class, SettingEntity::class],
    version = BDD_VERSION
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val BDD_VERSION = 1
    }

    abstract fun achievementsDao(): AchievementDao
    abstract fun factDao(): FactDao
    abstract fun categoryDao(): CategoryDao
    abstract fun settingsDao(): SettingDao
}