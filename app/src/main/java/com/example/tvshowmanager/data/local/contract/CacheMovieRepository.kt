package com.example.tvshowmanager.data.local.contract

import com.example.tvshowmanager.data.local.models.CachedMovieEntity
import kotlinx.coroutines.flow.Flow
import java.util.*

interface CacheMovieRepository {

    suspend fun saveMovie(title: String, releaseDate: Date, seasons: Int)

    fun getAllMovies(): Flow<List<CachedMovieEntity>>

}