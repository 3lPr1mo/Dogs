package com.example.dogs.data.network

import com.example.dogs.core.RetrofitHelper
import com.example.dogs.data.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogService {
    private val retrofit = RetrofitHelper.getRetrofit()
    //It execute in secondary thread to not overcharge the primary thread (ui)
    suspend fun getDogs(): List<Dog>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(DogApiClient::class.java).getDog()
            response.body() ?: emptyList()
        }
    }
}