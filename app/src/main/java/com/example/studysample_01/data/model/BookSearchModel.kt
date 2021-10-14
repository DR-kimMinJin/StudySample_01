package com.example.studysample_01.data.model

import com.example.studysample_01.data.Model
import com.google.gson.annotations.SerializedName

data class BookSearchModel(
    @SerializedName("total")
    val totalCount: Int,
    @SerializedName("start")
    val pageableCount: Int,
    @SerializedName("is_end")
    val isEnd: Boolean,
    @SerializedName("items")
    val items: List<BookInfoModel>
) : Model()

