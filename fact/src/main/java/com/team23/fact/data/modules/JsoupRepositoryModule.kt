package com.team23.fact.data.modules

import com.team23.fact.data.repositories.JsoupRepository
import com.team23.fact.data.repositories.JsoupRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class JsoupRepositoryModule {
    @Binds
    abstract fun bindJsoupRepository(jsoupRepositoryImpl: JsoupRepositoryImpl): JsoupRepository
}