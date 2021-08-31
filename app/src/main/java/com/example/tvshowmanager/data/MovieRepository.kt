package com.example.tvshowmanager.data

import com.example.tvshowmanager.data.model.Movie
import kotlinx.coroutines.flow.Flow
import java.util.*

interface MovieRepository {
    suspend fun saveMovie(title: String, releaseDate: Date, seasons: Double)
    fun getAllMovies(): Flow<List<Movie>>
}