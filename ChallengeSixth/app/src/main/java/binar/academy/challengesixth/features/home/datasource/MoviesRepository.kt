package binar.academy.challengesixth.features.home.datasource

import binar.academy.challengesixth.features.home.networkapi.ApiHelper

class MoviesRepository(private val movieDataSource: MovieDataSource) {
    suspend fun getMovies() = movieDataSource.getMovies()
}