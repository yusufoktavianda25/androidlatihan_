package binar.academy.challengesixth.features.home.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import binar.academy.challengesixth.features.home.modal.GetAllMoviesResponse
import binar.academy.challengesixth.features.home.networkapi.ApiClient
import binar.academy.challengesixth.features.home.modal.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDataSource {
    private val _movie = MutableLiveData<List<Result>>()
    val movie: LiveData<List<Result>>
        get() = _movie


    fun getMovies(){
       ApiClient.retrofitService.allMovie()
            .enqueue(object : Callback<GetAllMoviesResponse> {
                override fun onResponse(
                    call: Call<GetAllMoviesResponse>,
                    response: Response<GetAllMoviesResponse>
                ) {
                    _movie.value=response.body()?.results
                }

            })
    }

}