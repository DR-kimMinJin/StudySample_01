package com.example.studysample_01.data

import android.util.Log
import com.example.studysample_01.data.model.BookSearchMapper
import com.example.studysample_01.domain.entity.BookSearchEntity
import com.example.studysample_01.utils.ServiceApi
import com.example.studysample_01.utils.Result
import javax.inject.Inject

class BookRemoteDataSourceImpl @Inject constructor(
    private val serviceApi: ServiceApi
) : BaseRemoteDataSource(), BookRemoteDataSource {

    override suspend fun getBookInfo(keyword: String): Result<BookSearchEntity> {

        Log.d("로그","bookRemoteDataSourceImpl ${serviceApi.getSearchBook(keyword)}")

        return getResult(BookSearchMapper) {
            serviceApi.getSearchBook(
                query = keyword
            )
        }
    }


}