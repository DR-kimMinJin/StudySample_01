package com.example.studysample_01.data.model

import com.example.studysample_01.data.Model
import com.google.gson.annotations.SerializedName

data class BookInfoModel(
    @SerializedName("author")
    val author: String?,         // 저자
    @SerializedName("description")
    val description: String?,    // 책 설명
    @SerializedName("title")
    val title: String,          // 제목
    @SerializedName("image")
    val image: String,          // 이미지
    @SerializedName("price")
    val price: String?           // 가격
) : Model()