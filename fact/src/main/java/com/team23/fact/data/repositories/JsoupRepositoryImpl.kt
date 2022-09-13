package com.team23.fact.data.repositories

import com.team23.fact.data.const.JsoupConst
import com.team23.fact.domain.models.OpenGraphResult
import com.team23.fact.domain.repositories.JsoupRepository
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import javax.inject.Inject

class JsoupRepositoryImpl @Inject constructor() : JsoupRepository {

    override suspend fun getOpenGraphFromUrl(url: String): OpenGraphResult {
        runCatching {
            val parsedValues = Jsoup.connect(url)
                .ignoreContentType(true)
                .userAgent(JsoupConst.AGENT)
                .referrer(JsoupConst.REFERRER)
                .timeout(JsoupConst.TIMEOUT)
                .followRedirects(true)
                .execute()
                .parse()
            val attributes = parsedValues.select(JsoupConst.DOC_SELECT_QUERY)
            return OpenGraphResult(
                title = attributes.getValue(JsoupConst.OG_TITLE)
                    ?: parsedValues.select("html").select("head").select("title").text(),
                description = attributes.getValue(JsoupConst.OG_DESCRIPTION),
                url = url,
                image = attributes.getValue(JsoupConst.OG_IMAGE),
                siteName = attributes.getValue(JsoupConst.OG_SITE_NAME),
                type = attributes.getValue(JsoupConst.OG_TYPE),
                favicon = attributes.getValue(JsoupConst.OG_FAVICON).let {
                    if (it.isIconInCorrect()) {
                        url.getImageBySite(parsedValues)
                    } else {
                        it
                    }
                },
                language = parsedValues.select("html").attr("lang"),
            )
        }.also {
            return OpenGraphResult()
        }
    }

    private fun List<Element>.getValue(property: String) =
        this.firstOrNull { it.attr("property") == property }?.attr("content")

    private fun String?.isIconInCorrect() = this == null || this.isBlank() || this.endsWith("/.png")

    private fun String.getImageBySite(parsedValues: Document) = when {
        this.contains("wikipedia") || this.contains("curl.se") -> this.split("://").let {
            "${it[0]}://${it[1].split("/")[0]}${
                parsedValues.select("link[rel^=icon]").firstOrNull()?.attr( "href")
            }"
        }
        this.contains("betterexplained.com") || this.contains("songfacts.com")->
            parsedValues.select("img")[0].attr("src")
        this.contains("proofwiki.org") ->
            "https://proofwiki.org${parsedValues.select("img")[0].attr("src")}"
        this.contains("villemin.gerard.free.fr") ->
            "http://villemin.gerard.free.fr/GVCV_fichiers/image013.jpg"
        this.contains("lucaswillems") ->
            "https://www.lucaswillems.com/img/lcswillems-400x400.png"
        this.contains("maeckes") -> "http://www.maeckes.nl/clips/logo%20maeckes.gif"
        else -> null
    }
}