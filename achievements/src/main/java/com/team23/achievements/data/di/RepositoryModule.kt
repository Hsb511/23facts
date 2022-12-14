package com.team23.achievements.data.di

import com.team23.achievements.data.repositories.AchievementRepositoryImpl
import com.team23.achievements.data.repositories.FactAchievementRepositoryImpl
import com.team23.achievements.repositories.AchievementRepository
import com.team23.achievements.repositories.FactAchievementRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    internal abstract fun bindAchievementRepository(achievementRepositoryImpl: AchievementRepositoryImpl): AchievementRepository

    @Binds
    internal abstract fun bindFactRepository(factRepositoryImpl: FactAchievementRepositoryImpl): FactAchievementRepository
}