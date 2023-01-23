package com.team23.room.data.modules

import android.content.Context
import androidx.room.Room
import com.team23.room.data.AppDatabase
import com.team23.room.data.AppDatabase.Companion.migrationFrom1To2
import com.team23.room.data.Scripts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {
    private const val LOCAL_DB_NAME = "23facts.sqlite"
    private var appDatabase: AppDatabase? = null

    @Provides
    fun provide23FactsDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = appDatabase ?:
        Room.databaseBuilder(context, AppDatabase::class.java, LOCAL_DB_NAME)
        .addMigrations(
            migrationFrom1To2,
        )
        .build().also { db ->
            Scripts.categoriesScript.execSQL(db)
            Scripts.factsScript1.execSQL(db)
            Scripts.factsScript2.execSQL(db)
            Scripts.achievementScript.execSQL(db)
        }

    @Provides
    fun provideAchievementsDao(db: AppDatabase) = db.achievementsDao()

    @Provides
    fun provideCategoryDao(db: AppDatabase) = db.categoryDao()

    @Provides
    fun provideFactDao(db: AppDatabase) = db.factDao()

    @Provides
    fun provideSettingsDao(db: AppDatabase) = db.settingsDao()

    private fun String.execSQL(db: AppDatabase) {
        this.trimIndent().split("\n").forEach {
            db.openHelper.writableDatabase.execSQL(it)
        }
    }
}