package com.example.tvshowmanager.ui.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowmanager.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddNewTvShowFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _createMovieResponse =
        MutableStateFlow<CreateMovieResponse>(CreateMovieResponse.Initial)
    val createMovieResponse: StateFlow<CreateMovieResponse> = _createMovieResponse.asStateFlow()

    fun saveMovie(title: String, releaseDate: Date, seasons: Double) {
        viewModelScope.launch {
            _createMovieResponse.value = CreateMovieResponse.Loading
            val response = runCatching {
                movieRepository.saveMovie(title, releaseDate, seasons)
            }
            response.onSuccess { _createMovieResponse.value = CreateMovieResponse.Successful }
            response.onFailure {
                _createMovieResponse.value = CreateMovieResponse.Failure(
                    it.message ?: "Something went wrong, please try again later"
                )
            }
        }
    }

    sealed class CreateMovieResponse {
        object Initial : CreateMovieResponse()
        object Loading : CreateMovieResponse()
        object Successful : CreateMovieResponse()
        data class Failure(val message: String) : CreateMovieResponse()
    }
}