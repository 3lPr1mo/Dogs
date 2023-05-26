package com.example.dogs.data.network

import com.example.dogs.data.model.Dog
import retrofit2.http.GET

interface DogApiClient {
    @GET("chow/image")
    suspend fun getDog(): retrofit2.Response<List<Dog>>
}