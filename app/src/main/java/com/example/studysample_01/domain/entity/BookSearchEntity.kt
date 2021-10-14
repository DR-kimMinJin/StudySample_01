package com.example.studysample_01.domain.entity

import com.example.studysample_01.domain.Entity

// TODO : var, val 차이점
// TODO : 카멜 형식으로 변
data class BookSearchEntity(
    val totalCount: Int,
    val pageableCount: Int,
    val isEnd: Boolean,
    val items: List<BookInfoEntity>
) : Entity()


