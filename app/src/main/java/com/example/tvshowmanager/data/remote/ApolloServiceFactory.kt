package com.example.tvshowmanager.data.remote

import com.apollographql.apollo.ApolloClient
import com.example.tvshowmanager.data.remote.interceptor.AuthorizationInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object ApolloServiceFactory {
    private const val BASE_URL: String = "https://tv-show-manager.combyne.com/graphql"

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(AuthorizationInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    fun provideApolloClient(isDebug: Boolean): ApolloClient {
        val okHttpClient: OkHttpClient = makeOkHttpClient(
            makeLoggingInterceptor((isDebug))
        )
        return ApolloClient.builder().serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }
}