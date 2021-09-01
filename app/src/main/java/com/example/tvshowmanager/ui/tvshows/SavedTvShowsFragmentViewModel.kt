package com.example.tvshowmanager.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tvshowmanager.data.MovieRepository
import com.example.tvshowmanager.data.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SavedTvShowsFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {

    /** Opted to convert the flow from the data layer to a LiveData observable
     * as it much suites the use-case of not having to observe the flow only when the
     * view e.g Fragment or Activity lifecycle is in a started state
     * as LiveData does that underneath the hood for us*/
    val savedMovies: LiveData<List<Movie>> get() = movieRepository.getAllMovies().asLiveData()
}