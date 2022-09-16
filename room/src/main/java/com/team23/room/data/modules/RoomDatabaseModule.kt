package com.team23.room.data.modules

import android.content.Context
import androidx.room.Room
import com.team23.room.data.AppDatabase
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
    ): AppDatabase =
        appDatabase ?: Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            LOCAL_DB_NAME
        ).build().also { db ->
            Scripts.categoriesScript.trimIndent().split("\n").forEach {
                db.openHelper.writableDatabase.execSQL(it)
            }
            Scripts.factsScript.trimIndent().split("\n").forEach {
                db.openHelper.writableDatabase.execSQL(it)
            }
        }

    @Provides
    fun provideAchievementsDao(db: AppDatabase) = db.achievementsDao()

    @Provides
    fun provideCategoryDao(db: AppDatabase) = db.categoryDao()

    @Provides
    fun provideFactDao(db: AppDatabase) = db.factDao()

    @Provides
    fun provideSettingsDao(db: AppDatabase) = db.settingsDao()
}