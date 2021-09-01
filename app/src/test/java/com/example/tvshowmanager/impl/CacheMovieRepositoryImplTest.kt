package com.example.tvshowmanager.impl

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tvshowmanager.data.impl.CacheMovieRepositoryImpl
import com.example.tvshowmanager.data.local.contract.CacheMovieRepository
import com.example.tvshowmanager.data.local.database.TvShowsDatabase
import com.example.tvshowmanager.data.local.models.CachedMovieEntity
import com.example.tvshowmanager.models.DummyData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CacheMovieRepositoryImplTest {

    private lateinit var movieDatabase: TvShowsDatabase
    private lateinit var cacheMovieRepository: CacheMovieRepository

    @Before
    fun setUp() {
        movieDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TvShowsDatabase::class.java
        ).allowMainThreadQueries().build()

        cacheMovieRepository = CacheMovieRepositoryImpl(
            movieDatabase = movieDatabase
        )
    }

    @Test
    fun `check that saveMovie inserts data into database`(): Unit = runBlocking {
        val cachedMovieEntity: CachedMovieEntity = DummyData.movieEntity

        cacheMovieRepository.saveMovie(cachedMovieEntity)

        val result: List<CachedMovieEntity> = cacheMovieRepository.getAllMovies().first()
        assertThat(result).isNotNull()
    }
}