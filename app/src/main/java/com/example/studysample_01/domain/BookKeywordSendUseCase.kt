package com.example.studysample_01.domain

import javax.inject.Inject

class BookKeywordSendUseCase @Inject constructor(
    private val bookKeywordSendRepository: BookKeywordSendRepository
) {

    fun bookKeywordSend(keyword: String) : String {
        return bookKeywordSendRepository.searchKeywordSend(keyword = keyword)
    }

}