package com.example.tvshowmanager.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Movie")
data class CachedMovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val releaseDate: Date,
    val seasons: Int
)