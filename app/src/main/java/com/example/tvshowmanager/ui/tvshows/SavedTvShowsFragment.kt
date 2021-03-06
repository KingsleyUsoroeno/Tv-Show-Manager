package com.example.tvshowmanager.ui.tvshows

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tvshowmanager.data.model.Movie
import com.example.tvshowmanager.databinding.FragmentSavedTvShowsBinding
import com.example.tvshowmanager.ui.adapters.TvShowsRecyclerViewAdapter
import com.example.tvshowmanager.ui.main.BaseFragment
import com.example.tvshowmanager.utils.extensions.hide
import com.example.tvshowmanager.utils.extensions.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedTvShowsFragment : BaseFragment<FragmentSavedTvShowsBinding>() {

    private val fragmentViewModel: SavedTvShowsFragmentViewModel by viewModels()

    override fun getLayoutBinding(container: ViewGroup?): FragmentSavedTvShowsBinding {
        return FragmentSavedTvShowsBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentViewModel.savedMovies.observe(this.viewLifecycleOwner, { movies ->
            initRecyclerView(movies)
        })
    }

    private fun initRecyclerView(movies: List<Movie>) {
        with(binding) {
            if (movies.isNullOrEmpty()) {
                tvShowsRecyclerView.hide
                emptyStateView.show

            } else {
                val adapter = TvShowsRecyclerViewAdapter().apply { submitList(movies) }
                emptyStateView.hide
                tvShowsRecyclerView.show
                binding.tvShowsRecyclerView.adapter = adapter
            }
        }
    }
}