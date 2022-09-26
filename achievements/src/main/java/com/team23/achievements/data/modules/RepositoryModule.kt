package com.team23.achievements.data.modules

import com.team23.achievements.data.repositories.AchievementRepositoryImpl
import com.team23.achievements.data.repositories.FactRepositoryImpl
import com.team23.achievements.domain.repositories.AchievementRepository
import com.team23.achievements.domain.repositories.FactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAchievementRepository(achievementRepositoryImpl: AchievementRepositoryImpl): AchievementRepository

    @Binds
    abstract fun bindFactRepository(factRepositoryImpl: FactRepositoryImpl): FactRepository
}