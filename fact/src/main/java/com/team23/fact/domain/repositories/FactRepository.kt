package com.team23.fact.domain.repositories

import com.team23.fact.domain.models.FactModel

interface FactRepository {
    suspend fun getFactById(id: Long, language: String): FactModel?
}