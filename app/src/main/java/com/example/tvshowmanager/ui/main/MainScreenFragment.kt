package com.example.tvshowmanager.ui.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.example.tvshowmanager.R
import com.example.tvshowmanager.databinding.FragmentMainScreenBinding

class MainScreenFragment : BaseFragment<FragmentMainScreenBinding>() {
    override fun getLayoutBinding(container: ViewGroup?): FragmentMainScreenBinding {
        return FragmentMainScreenBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnAddNewTvShow.setOnClickListener {
                navigate(R.id.action_mainScreenFragment_to_addNewTvShowFragment)
            }

            btnShowAddedShows.setOnClickListener {
                navigate(R.id.action_mainScreenFragment_to_savedTvShowsFragment)
            }
        }
    }
}