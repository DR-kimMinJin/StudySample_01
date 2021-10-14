package com.example.studysample_01.data

import com.example.studysample_01.domain.BookKeywordSendRepository
import javax.inject.Inject

class BookKeywordSendRepositoryImpl @Inject constructor() : BookKeywordSendRepository {

    override fun searchKeywordSend(keyword: String): String {
        return keyword
    }
}