package com.team23.search.data.di

import com.team23.search.repositories.FactSearchRepository
import com.team23.search.data.repositories.FactSearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindFactRepository(factSearchRepositoryImpl: FactSearchRepositoryImpl): FactSearchRepository
}