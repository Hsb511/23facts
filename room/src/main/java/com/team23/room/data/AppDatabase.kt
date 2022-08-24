package com.team23.room.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.team23.room.data.AppDatabase.Companion.BDD_VERSION
import com.team23.room.data.daos.CategoryDao
import com.team23.room.data.daos.FactDao
import com.team23.room.data.entities.CategoryEntity
import com.team23.room.data.entities.FactEntity

@Database(
    entities = [FactEntity::class, CategoryEntity::class],
    version = BDD_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val BDD_VERSION = 1
    }

    abstract fun factDao(): FactDao
    abstract fun categoryDao(): CategoryDao
}