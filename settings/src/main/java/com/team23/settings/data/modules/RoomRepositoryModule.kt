package com.team23.settings.data.modules

import com.team23.settings.data.repositories.AchievementRoomRepository
import com.team23.settings.data.repositories.FactRoomRepository
import com.team23.settings.domain.repositories.AchievementRepository
import com.team23.settings.domain.repositories.FactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RoomRepositoryModule {

    @Binds
    abstract fun bindFactRepository(factRoomRepository: FactRoomRepository): FactRepository

    @Binds
    abstract fun bindAchievementRepository(achievementRoomRepository: AchievementRoomRepository): AchievementRepository
}