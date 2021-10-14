package com.example.studysample_01.domain

import com.example.studysample_01.domain.entity.BookSearchEntity
import com.example.studysample_01.utils.Result

interface BookSearchRepository {

    suspend fun getBookList(keyword: String) : Result<BookSearchEntity>
}