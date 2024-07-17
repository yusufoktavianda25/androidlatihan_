package binar.academy.challengesixth.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import binar.academy.challengesixth.features.home.datasource.MoviesRepository
import binar.academy.challengesixth.features.home.datasource.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {
    fun getAllMoviesData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = moviesRepository.getMovies()))
        } catch (exeption : Exception){
            emit(Resource.error(data = null, message = exeption.message ?: "Error Occoured!"))
        }

    }
}