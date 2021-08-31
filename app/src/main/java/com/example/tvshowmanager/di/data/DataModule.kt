package com.example.tvshowmanager.di.data

import com.example.tvshowmanager.data.MovieRepository
import com.example.tvshowmanager.data.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @get:[Binds Singleton]
    val MovieRepositoryImpl.bindMovieRepository: MovieRepository
}