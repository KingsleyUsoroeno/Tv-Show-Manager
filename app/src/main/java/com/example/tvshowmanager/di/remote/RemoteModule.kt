package com.example.tvshowmanager.di.remote

import com.apollographql.apollo.ApolloClient
import com.example.tvshowmanager.BuildConfig
import com.example.tvshowmanager.data.impl.MovieRemoteRepositoryImpl
import com.example.tvshowmanager.data.remote.ApolloServiceFactory
import com.example.tvshowmanager.data.remote.contract.MovieRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RemoteModule {

    @get:[Binds Singleton]
    val MovieRemoteRepositoryImpl.bindMovieRepository: MovieRemoteRepository

    companion object {

        @[Provides Singleton]
        fun provideApolloService(): ApolloClient =
            ApolloServiceFactory.provideApolloClient(BuildConfig.DEBUG)
    }
}