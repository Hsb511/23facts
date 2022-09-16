package com.team23.achievements.data.modules

import com.team23.achievements.data.repositories.AchievementRepositoryImpl
import com.team23.achievements.domain.repositories.AchievementRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class AchievementModule {
    @Binds
    abstract fun bindAchievementRepository(achievementRepositoryImpl: AchievementRepositoryImpl): AchievementRepository
}