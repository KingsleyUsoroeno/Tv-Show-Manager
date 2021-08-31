package com.example.tvshowmanager.presentation.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvshowmanager.databinding.LayoutSavedShowItemBinding
import com.example.tvshowmanager.data.model.Movie


class TvShowsViewHolder private constructor(
    private val binding:
    LayoutSavedShowItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        with(binding) {
            txtMovieName.text = movie.title
            txtMovieMovieReleaseDate.text = movie.releaseDate
            txtMovieSeasons.text = movie.seasons.toString()
        }
    }

    companion object {
        @JvmStatic
        fun new(inflater: LayoutInflater, parent: ViewGroup?): TvShowsViewHolder {
            val binding = LayoutSavedShowItemBinding.inflate(inflater, parent, false)
            return TvShowsViewHolder(binding)
        }
    }
}