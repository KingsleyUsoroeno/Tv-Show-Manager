package com.example.tvshowmanager.data.remote.contract

import java.util.*

interface MovieRemoteRepository {
    suspend fun createMovie(title: String, releaseDate: Date, seasons: Float)
}