package com.example.dogs.data

import com.example.dogs.data.model.Dog
import com.example.dogs.data.model.DogProvider
import com.example.dogs.data.network.DogService

class DogRepository {
    private val api = DogService()

    suspend fun getAllDogs(): List<Dog>{
        val response = api.getDogs()
        DogProvider.dogs = response
        return response
    }
}