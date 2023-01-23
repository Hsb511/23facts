package com.team23.room.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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
    version = BDD_VERSION,
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val BDD_VERSION = 2

        val migrationFrom1To2 = object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                val cursor = database.query("SELECT DISTINCT id_fonc FROM T_FACT WHERE isNew = 0")
                val readFactIds: MutableList<Long> = mutableListOf()
                while (cursor.moveToNext()) {
                    readFactIds.add(cursor.getLong(0))
                }
                database.delete("T_FACT", null, null)
                database.execSQL(Scripts.factsScript1)
                database.execSQL(Scripts.factsScript2)
                readFactIds.forEach { factId ->
                    database.execSQL("UPDATE T_FACT SET isNew = 0 WHERE id_fonc = $factId")
                }
            }
        }
    }

    abstract fun achievementsDao(): AchievementDao
    abstract fun factDao(): FactDao
    abstract fun categoryDao(): CategoryDao
    abstract fun settingsDao(): SettingDao
}