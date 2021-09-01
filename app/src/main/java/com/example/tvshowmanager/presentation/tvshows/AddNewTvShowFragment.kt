package com.example.tvshowmanager.presentation.tvshows

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tvshowmanager.R
import com.example.tvshowmanager.databinding.FragmentAddNewTvShowBinding
import com.example.tvshowmanager.presentation.main.BaseFragment
import com.example.tvshowmanager.utils.extensions.hide
import com.example.tvshowmanager.utils.extensions.show
import com.example.tvshowmanager.utils.extensions.textString
import com.example.tvshowmanager.utils.extensions.validate
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddNewTvShowFragment : BaseFragment<FragmentAddNewTvShowBinding>() {

    private val viewModel: AddNewTvShowFragmentViewModel by viewModels()

    override fun getLayoutBinding(container: ViewGroup?): FragmentAddNewTvShowBinding {
        return FragmentAddNewTvShowBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                createMovieResponse.collect {
                    when (it) {
                        is AddNewTvShowFragmentViewModel.CreateMovieResponse.Initial -> {
                        }

                        is AddNewTvShowFragmentViewModel.CreateMovieResponse.Loading -> {
                            binding.progressBar.show
                            binding.btnAddNewTvShow.hide
                        }

                        is AddNewTvShowFragmentViewModel.CreateMovieResponse.Successful -> {
                            binding.progressBar.hide
                            binding.btnAddNewTvShow.show
                            pop()
                        }

                        is AddNewTvShowFragmentViewModel.CreateMovieResponse.Failure -> {
                            binding.progressBar.hide
                            binding.btnAddNewTvShow.show
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }

        with(binding) {
            edtReleaseDate.setOnClickListener { showDatePicker() }

            btnAddNewTvShow.setOnClickListener {
                val tvShowError = getString(R.string.text_provide_a_tv_show_name)
                val releaseDateError = getString(R.string.text_provide_a_valid_release_date)
                val seasonError = getString(R.string.text_provide_a_valid_season_count)

                val isValidTvShow = textInputTvShow.validate(tvShowError) { it.isNotEmpty() }
                val isValidReleaseDate =
                    textInputReleaseDate.validate(releaseDateError) { it.isNotEmpty() }
                val isValidSeason = textInputSeason.validate(seasonError) { it.isNotEmpty() }

                if (isValidTvShow && isValidReleaseDate && isValidSeason) {
                    viewModel.saveMovie(
                        title = edtTvShow.textString,
                        releaseDate = stringToDate(edtReleaseDate.textString),
                        seasons = edtSeason.textString.toDouble()
                    )
                }
            }
        }
    }

    private fun showDatePicker() {
        val builder = MaterialDatePicker.Builder.datePicker()
        val picker = builder.build()
        picker.show(requireActivity().supportFragmentManager, picker.toString())
        picker.addOnPositiveButtonClickListener {
            binding.edtReleaseDate.setText(picker.headerText)
        }
    }

    private fun stringToDate(releaseDate: String): Date {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.parse(releaseDate) ?: Date()
    }
}