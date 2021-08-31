package com.example.tvshowmanager.presentation.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tvshowmanager.data.MovieRepository
import com.example.tvshowmanager.data.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SavedTvShowsViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {

    val movies: LiveData<List<Movie>> get() = movieRepository.getAllMovies().asLiveData()
}