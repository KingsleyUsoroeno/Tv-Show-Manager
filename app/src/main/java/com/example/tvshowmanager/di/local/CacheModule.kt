package com.example.tvshowmanager.di.local

import android.content.Context
import com.example.tvshowmanager.data.local.database.TvShowsDatabase
import com.example.tvshowmanager.data.local.database.daos.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface CacheModule {

    companion object {
        @[Provides Singleton]
        fun provideDatabase(@ApplicationContext context: Context): TvShowsDatabase {
            return TvShowsDatabase.build(context)
        }

        @[Provides Singleton]
        fun provideMovieDao(tvShowsDatabase: TvShowsDatabase): MovieDao {
            return tvShowsDatabase.movieDao
        }
    }
}