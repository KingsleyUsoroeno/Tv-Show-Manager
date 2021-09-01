package com.example.tvshowmanager.data.local.contract

import com.example.tvshowmanager.data.local.models.CachedMovieEntity
import kotlinx.coroutines.flow.Flow

interface CacheMovieRepository {

    suspend fun saveMovie(movie: CachedMovieEntity)

    fun getAllMovies(): Flow<List<CachedMovieEntity>>
}