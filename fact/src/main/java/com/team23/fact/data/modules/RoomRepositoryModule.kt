package com.team23.fact.data.modules

import com.team23.fact.data.repositories.CategoryRoomRepository
import com.team23.fact.data.repositories.FactRoomRepository
import com.team23.fact.domain.repositories.CategoryRepository
import com.team23.fact.domain.repositories.FactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RoomRepositoryModule {
    @Binds
    abstract fun bindCategoryRepository(categoryRoomRepository: CategoryRoomRepository): CategoryRepository

    @Binds
    abstract fun bindFactRepository(factRoomRepository: FactRoomRepository): FactRepository

}