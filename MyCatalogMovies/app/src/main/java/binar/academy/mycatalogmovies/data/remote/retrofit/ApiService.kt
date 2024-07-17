package binar.academy.mycatalogmovies.data.remote.retrofit

import binar.academy.mycatalogmovies.data.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getmovie(
        @Query("api_key") apiKey: String
    ): Call<MovieResponse>
}