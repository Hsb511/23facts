package com.team23.fact.domain.usecases

import com.team23.fact.data.repositories.JsoupRepository
import com.team23.fact.domain.models.OpenGraphResult
import javax.inject.Inject

class GetOpenGraphMetaDataFromUrlUseCase @Inject constructor(
    private val jsoupRepository: JsoupRepository
){
    suspend fun execute(url: String): OpenGraphResult {
        val correctUrl = if (!url.startsWith("http")) {
            "http://$url"
        } else {
            url
        }
        return jsoupRepository.getOpenGraphFromUrl(url)
    }
}