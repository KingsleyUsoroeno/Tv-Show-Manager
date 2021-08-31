package com.example.tvshowmanager.presentation.tvshows

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.example.tvshowmanager.R
import com.example.tvshowmanager.databinding.FragmentAddNewTvShowBinding
import com.example.tvshowmanager.presentation.main.BaseFragment
import com.example.tvshowmanager.utils.validate

class AddNewTvShowFragment : BaseFragment<FragmentAddNewTvShowBinding>() {
    override fun getLayoutBinding(container: ViewGroup?): FragmentAddNewTvShowBinding {
        return FragmentAddNewTvShowBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnAddNewTvShow.setOnClickListener {
                val tvShowError = getString(R.string.text_provide_a_tv_show_name)
                val releaseDateError = getString(R.string.text_provide_a_valid_release_date)
                val seasonError = getString(R.string.text_provide_a_valid_season_count)

                val isValidTvShow = edtTvShow.validate(tvShowError) { it.isNotEmpty() }
                val isValidReleaseDate =
                    edtReleaseDate.validate(releaseDateError) { it.isNotEmpty() }
                val isValidSeason = edtSeasons.validate(seasonError) { it.isNotEmpty() }

                if (isValidTvShow && isValidReleaseDate && isValidSeason) {
                    TODO()
                }
            }
        }
    }
}