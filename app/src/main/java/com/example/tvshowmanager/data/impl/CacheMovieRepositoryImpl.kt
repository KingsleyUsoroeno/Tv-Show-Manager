package com.example.tvshowmanager.data.impl

import com.example.tvshowmanager.data.local.contract.CacheMovieRepository
import com.example.tvshowmanager.data.local.database.TvShowsDatabase
import com.example.tvshowmanager.data.local.models.CachedMovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CacheMovieRepositoryImpl @Inject constructor(
    private val movieDatabase: TvShowsDatabase
) : CacheMovieRepository {

    private val movieDao get() = movieDatabase.movieDao

    override suspend fun saveMovie(movie: CachedMovieEntity) {
        withContext(Dispatchers.IO) {
            movieDao.insertMovie(movie)
        }
    }

    override fun getAllMovies(): Flow<List<CachedMovieEntity>> {
        return movieDao.getAllMovies()
    }
}