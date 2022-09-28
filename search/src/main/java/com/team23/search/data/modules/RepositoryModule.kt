package com.team23.search.data.modules

import com.team23.search.data.repositories.FactRoomRepository
import com.team23.search.domain.repositories.FactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindFactRepository(factRoomRepository: FactRoomRepository): FactRepository
}