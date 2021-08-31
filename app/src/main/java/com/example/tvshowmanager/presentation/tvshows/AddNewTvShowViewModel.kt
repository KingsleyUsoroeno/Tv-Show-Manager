package com.example.tvshowmanager.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowmanager.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddNewTvShowViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    fun saveMovie(title: String, releaseDate: Date, seasons: Double) {
        viewModelScope.launch {
            movieRepository.saveMovie(title, releaseDate, seasons)
        }
    }
}