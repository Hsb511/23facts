package com.team23.home.data.modules

import com.team23.home.data.repositories.CategoryRoomRepository
import com.team23.home.domain.repositories.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CategoryRepositoryModule {

    @Binds
    abstract fun bindCategoryRepository(categoryRoomRepository: CategoryRoomRepository): CategoryRepository
}