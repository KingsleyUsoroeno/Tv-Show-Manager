package com.example.tvshowmanager.data

import com.example.tvshowmanager.data.local.contract.CacheMovieRepository
import com.example.tvshowmanager.data.local.models.CachedMovieEntity
import com.example.tvshowmanager.data.model.Movie
import com.example.tvshowmanager.data.remote.contract.MovieRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRepository: MovieRemoteRepository,
    private val cacheMovieRepository: CacheMovieRepository
) : MovieRepository {

    override suspend fun saveMovie(title: String, releaseDate: Date, seasons: Double) {
        try {
            val movie = movieRepository.createMovie(title, releaseDate, seasons)
            movie?.let {
                val cachedMovieEntity = CachedMovieEntity(
                    id = it.id,
                    title = it.title,
                    releaseDate = convertToDate(it.releaseDate),
                    seasons = it.seasons?.toInt() ?: 0
                )
                cacheMovieRepository.saveMovie(cachedMovieEntity)
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getAllMovies(): Flow<List<Movie>> {
        return cacheMovieRepository.getAllMovies().map { cachedMovies ->
            cachedMovies.map { it.toMovie() }
        }
    }

    private fun convertToDate(releaseDate: Any?): Date {
        val sdf = SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss",
            Locale.getDefault()
        )
        return sdf.parse(releaseDate.toString()) ?: Date()
    }
}