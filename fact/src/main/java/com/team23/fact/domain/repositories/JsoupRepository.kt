package com.team23.fact.domain.repositories

import com.team23.fact.domain.models.OpenGraphResult

interface JsoupRepository {
    suspend fun getOpenGraphFromUrl(url: String): OpenGraphResult
}