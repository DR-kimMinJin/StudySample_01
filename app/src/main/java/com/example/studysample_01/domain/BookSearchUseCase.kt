package com.example.studysample_01.domain

import android.util.Log
import com.example.studysample_01.domain.di.IoDispatcher
import com.example.studysample_01.domain.entity.BookSearchEntity
import com.example.studysample_01.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

// TODO : UseCase 는 하나의 기능만을 담당해야 한다.
open class BookSearchUseCase @Inject constructor(
    // TODO : Dispatcher 를 주입해줘야 한다.
    private val bookSearchRepository: BookSearchRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<BookSearchUseCase.Params, BookSearchEntity>(ioDispatcher) {

    override suspend fun execute(params: Params): Result<BookSearchEntity> {
        return bookSearchRepository.getBookList(
            keyword = params.keyword
        )
    }

    data class Params(
        val keyword: String
    )
}

//    suspend fun getSearchBookInfo(keyword: String): SearchBookEntity {
//        return bookSearchRepository.getBookList(keyword)
//    }
//    fun setSearchKeywordSend(keyword: String): String {
//        return keyword
//    }