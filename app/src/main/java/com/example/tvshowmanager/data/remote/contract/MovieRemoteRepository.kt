package com.example.tvshowmanager.data.remote.contract

import com.example.tvshowmanager.CreateMovieMutation
import java.util.*

interface MovieRemoteRepository {
    suspend fun createMovie(
        title: String,
        releaseDate: Date,
        seasons: Double
    ): CreateMovieMutation.Movie? = throw Exception()
}