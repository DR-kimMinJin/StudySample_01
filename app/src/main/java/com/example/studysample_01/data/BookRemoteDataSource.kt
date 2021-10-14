package com.example.studysample_01.data

import com.example.studysample_01.domain.entity.BookSearchEntity
import com.example.studysample_01.utils.Result

interface BookRemoteDataSource {

    suspend fun getBookInfo(keyword: String) : Result<BookSearchEntity>

}