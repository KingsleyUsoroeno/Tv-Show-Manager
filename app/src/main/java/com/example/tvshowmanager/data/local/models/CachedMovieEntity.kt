package com.example.tvshowmanager.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tvshowmanager.data.model.Movie
import com.example.tvshowmanager.utils.extensions.timeString
import java.util.*

@Entity(tableName = "Movie")
data class CachedMovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val releaseDate: Date,
    val seasons: Int
) {
    fun toMovie(): Movie {
        return Movie(
            id = id,
            title = title,
            releaseDate = releaseDate.timeString,
            seasons = seasons.toInt()
        )
    }
}