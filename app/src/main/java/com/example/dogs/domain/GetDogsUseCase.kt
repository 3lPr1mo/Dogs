package com.example.dogs.domain

import com.example.dogs.data.DogRepository
import com.example.dogs.data.model.Dog

class GetDogsUseCase {

    private val repository = DogRepository()

    suspend operator fun invoke(): List<Dog> = repository.getAllDogs()

}