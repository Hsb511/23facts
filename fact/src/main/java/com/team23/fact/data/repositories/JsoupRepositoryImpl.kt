package com.team23.fact.data.repositories

import com.team23.fact.data.const.JsoupConst
import com.team23.fact.domain.models.OpenGraphResult
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import javax.inject.Inject

class JsoupRepositoryImpl @Inject constructor(): JsoupRepository {

    override suspend fun getOpenGraphFromUrl(url: String): OpenGraphResult {
        runCatching {
            val attributes = Jsoup.connect(url)
                .ignoreContentType(true)
                .userAgent(JsoupConst.AGENT)
                .referrer(JsoupConst.REFERRER)
                .timeout(JsoupConst.TIMEOUT)
                .followRedirects(true)
                .execute()
                .parse()
                .select(JsoupConst.DOC_SELECT_QUERY)
            return OpenGraphResult(
                title = attributes.getValue(JsoupConst.OG_TITLE),
                description = attributes.getValue(JsoupConst.OG_DESCRIPTION),
                url = url,
                image = attributes.getValue(JsoupConst.OG_IMAGE),
                siteName = attributes.getValue(JsoupConst.OG_SITE_NAME),
                type = attributes.getValue(JsoupConst.OG_TYPE)
            )
        }.also {
            return OpenGraphResult()
        }
    }

    private fun List<Element>.getValue(property: String) =
        this.firstOrNull { it.attr("property") == property }?.attr("content")
}