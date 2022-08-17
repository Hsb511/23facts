package com.team23.fact.data.repositories

import com.team23.fact.domain.models.OpenGraphResult

interface JsoupRepository {
    suspend fun getOpenGraphFromUrl(url: String): OpenGraphResult
}