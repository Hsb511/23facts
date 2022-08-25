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
        ).build().also { db ->
            """
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('MA', 'Mathematics', 'Mathématique');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('PC', 'Physics & Chemistry', 'Physique Chimie');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('BG', 'Biology & Geology', 'Biologie & Géologie');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('ME', 'Medicine', 'Médecine');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('CS', 'Computer Science', 'Informatique');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('VG', 'Video Games', 'Jeux vidéo');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('MU', 'Music', 'Musique');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('MS', 'Movie & Series', 'Film & Séries');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('AE', 'Art', 'Art');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('SP', 'Sport', 'Sport');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('RM', 'Religion & Mythology', 'Religion & mythologie');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('PL', 'Politics & Law', 'Politique & Droit');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('AM', 'Military & Aviation', 'Militaire & aviation');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('HI', 'History', 'Histoire');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('GE', 'Geography', 'Géographie');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('BD', 'Famous Birth & Death', 'Naissance & Mort célèbres');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('RN', 'Records & News', 'Recors & Faits divers');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('IB', 'Industry & Business', 'Industrie & Commerce');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('FE', 'Finance & Economics', 'Finance & Economie');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('AT', 'Automotive & Transportation', 'Automobile & Transport');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('GF', 'Gastronomy & Food product', 'Gastronomie & Produit alimentaire');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('SM', 'Social Media', 'Réseau social');
                INSERT OR IGNORE INTO T_CATEGORY VALUES ('OT', 'Others', 'Autres');
                """.trimIndent().split("\n").forEach {

                db.openHelper.writableDatabase.execSQL(it)
            }
        }


    @Provides
    fun provideCategoryDao(db: AppDatabase) = db.categoryDao()

    @Provides
    fun provideFactDao(db: AppDatabase) = db.factDao()
}