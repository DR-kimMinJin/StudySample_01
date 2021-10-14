package com.example.studysample_01.data.remote

import android.util.Log
import com.example.studysample_01.data.BookRemoteDataSource
import com.example.studysample_01.domain.BookSearchRepository
import com.example.studysample_01.domain.entity.BookSearchEntity
import com.example.studysample_01.utils.Result
import javax.inject.Inject

class BookSearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: BookRemoteDataSource
) : BookSearchRepository {

    override suspend fun getBookList(keyword: String): Result<BookSearchEntity> {

        return remoteDataSource.getBookInfo(keyword)
    }

}