package com.example.tvshowmanager.di.remote

import com.apollographql.apollo.ApolloClient
import com.example.tvshowmanager.BuildConfig
import com.example.tvshowmanager.data.remote.ApolloServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RemoteModule {

    companion object {

        @[Provides Singleton]
        fun provideApolloService(): ApolloClient =
            ApolloServiceFactory.provideApolloClient(BuildConfig.DEBUG)
    }
}