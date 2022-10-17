package com.uranium.gitlist.main.data.repository

import okhttp3.mockwebserver.MockResponse
import java.net.HttpURLConnection

private const val EMPTY_BODY = "{}"

data class DefaultResponseBuilder(
    val responseBodyFilePath: String? = null,
    val responseCode: Int = HttpURLConnection.HTTP_OK
) {
    private var resourceReader: ReadFile = ReadFile()

    fun build(): MockResponse {
        return MockResponse().setResponseCode(responseCode)
            .setBody(buildBody())
    }

    private fun buildBody(): String {
        return responseBodyFilePath?.let {
            resourceReader(it)
        } ?: run {
            EMPTY_BODY
        }
    }
}