package binar.academy.challengesixth.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import binar.academy.challengesixth.features.home.datasource.MoviesRepository
import binar.academy.challengesixth.features.home.networkapi.ApiHelper

class ViewModelFactory(private val moviesRepository: MoviesRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(moviesRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}