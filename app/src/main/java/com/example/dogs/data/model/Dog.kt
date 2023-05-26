package com.example.dogs.data.model

import com.google.gson.annotations.SerializedName

data class Dog (
    @SerializedName("message") var imgUrl: List<String>,
    @SerializedName("status") var status: String
    )