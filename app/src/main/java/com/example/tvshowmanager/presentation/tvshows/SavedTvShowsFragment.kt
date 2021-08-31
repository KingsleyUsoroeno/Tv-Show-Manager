package com.example.tvshowmanager.presentation.tvshows

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.example.tvshowmanager.databinding.FragmentSavedTvShowsBinding
import com.example.tvshowmanager.presentation.adapters.TvShowsRecyclerViewAdapter
import com.example.tvshowmanager.presentation.main.BaseFragment
import com.example.tvshowmanager.data.model.Movie

class SavedTvShowsFragment : BaseFragment<FragmentSavedTvShowsBinding>() {
    override fun getLayoutBinding(container: ViewGroup?): FragmentSavedTvShowsBinding {
        return FragmentSavedTvShowsBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, title = "Batman", releaseDate = "23 January 2020", seasons = 5))
        val intRange: IntRange = 1..20

        for (i in intRange) {
            movies.add(
                Movie(
                    1 + i,
                    title = "Batman $i",
                    releaseDate = "23 January 2020",
                    seasons = 5
                )
            )
        }

        println("movies is ${movies.size}")

        with(binding) {
            val adapter = TvShowsRecyclerViewAdapter()
            adapter.submitList(movies)
            tvShowsRecyclerView.adapter = adapter
        }
    }
}