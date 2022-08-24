package com.team23.room.data.modules

import android.content.Context
import androidx.room.Room
import com.team23.room.data.AppDatabase
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
        ).build().also {
            it.openHelper.writableDatabase
                // TODO .execSQL( )
        }


    @Provides
    fun provideCategoryDao(db: AppDatabase) = db.categoryDao()

    @Provides
    fun provideFactDao(db: AppDatabase) = db.factDao()
}