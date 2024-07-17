package binar.academy.challengesixth.features.home.networkapi

import binar.academy.challengesixth.features.home.networkapi.ApiService

class ApiHelper(private val apiService: ApiService) {
    suspend fun getAllMoviesData() = apiService.allMovie()
}