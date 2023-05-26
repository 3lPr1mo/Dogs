package com.example.dogs.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogs.data.model.Dog
import com.example.dogs.data.model.DogProvider
import com.example.dogs.domain.GetDogsUseCase
import kotlinx.coroutines.launch

class DogViewModel: ViewModel() {

    val dog = MutableLiveData<List<Dog>>()
    val isLoading = MutableLiveData<Boolean>()
    var getDogsUseCase = GetDogsUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDogsUseCase()
            Log.d("dog", result.toString())
            if(result.isNullOrEmpty()){
                dog.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}