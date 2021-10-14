package com.example.studysample_01.domain

interface BookKeywordSendRepository {

    fun searchKeywordSend(keyword: String): String

}