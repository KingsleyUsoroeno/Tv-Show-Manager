package com.example.tvshowmanager.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tvshowmanager.data.local.models.CachedMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(cachedMovieEntity: CachedMovieEntity)

    @Query("SELECT * FROM Movie")
    fun getAllMovies(): Flow<List<CachedMovieEntity>>

    @Query("DELETE FROM Movie")
    suspend fun clearData()
}