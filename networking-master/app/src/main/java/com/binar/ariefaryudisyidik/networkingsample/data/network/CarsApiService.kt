package com.binar.ariefaryudisyidik.networkingsample.data.network

import com.binar.ariefaryudisyidik.networkingsample.data.model.GetAllCarResponseItem
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rent-cars-api.herokuapp.com/"

private val logging: HttpLoggingInterceptor
    get() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CarsApiService {
    @GET("admin/car")
    fun allCar(): Call<List<GetAllCarResponseItem>>
}

object CarsApi {
    val retrofitService: CarsApiService by lazy { retrofit.create(CarsApiService::class.java) }
}