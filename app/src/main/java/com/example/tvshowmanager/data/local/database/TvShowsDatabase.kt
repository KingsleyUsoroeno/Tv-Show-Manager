package com.example.tvshowmanager.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tvshowmanager.data.local.converters.DateConverter
import com.example.tvshowmanager.data.local.database.daos.MovieDao
import com.example.tvshowmanager.data.local.models.CachedMovieEntity

@Database(entities = [CachedMovieEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class TvShowsDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {
        private const val DATABASE_NAME: String = "tv_shows_db"
        fun build(context: Context): TvShowsDatabase = Room.databaseBuilder(
            context.applicationContext,
            TvShowsDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
}