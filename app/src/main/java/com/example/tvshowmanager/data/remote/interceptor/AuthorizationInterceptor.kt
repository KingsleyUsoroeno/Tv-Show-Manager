package com.example.tvshowmanager.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

object AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
                "X-Parse-Client-Key",
                "yiCk1DW6WHWG58wjj3C4pB/WyhpokCeDeSQEXA5HaicgGh4pTUd+3/rMOR5xu1Yi"
            ).addHeader(
                "X-Parse-Application-Id",
                "AaQjHwTIQtkCOhtjJaN/nDtMdiftbzMWW5N8uRZ+DNX9LI8AOziS10eHuryBEcCI"
            )
            .build()

        return chain.proceed(request)
    }
}