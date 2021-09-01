package com.example.tvshowmanager.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.tvshowmanager.data.model.Movie
import com.example.tvshowmanager.ui.viewHolders.TvShowsViewHolder

class TvShowsRecyclerViewAdapter :
    ListAdapter<Movie, TvShowsViewHolder>(MovieDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return TvShowsViewHolder.new(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    object MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }
}