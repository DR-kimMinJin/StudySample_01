package com.example.studysample_01.utils

import com.google.gson.annotations.SerializedName

data class ResponseMapper<T>(

//    @SerializedName("code")
//    val code: Int,
//    @SerializedName("message")
//    val message: String,
    @SerializedName("items")
    val body: T? = null
)