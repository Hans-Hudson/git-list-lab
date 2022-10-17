package com.uranium.gitlist.setup.remote

import com.uranium.gitlist.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val url = request().url().newBuilder().build()
        proceed(
            request()
                .newBuilder()
                .url(url)
                .addHeader("Authorization", BuildConfig.GIT_TOKEN)
                .addHeader("Accept", "application/vnd.github+json")
                .build()
        )
    }
}