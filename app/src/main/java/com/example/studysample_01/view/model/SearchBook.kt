package com.example.studysample_01.view.model

import com.example.studysample_01.domain.entity.BookSearchEntity


data class SearchBook(
    val totalCount: Int,
    val pageableCount: Int,
    val isEnd: Boolean,
    val items: List<BookInfo>
)

fun BookSearchEntity.mapToItem(): SearchBook {
    return SearchBook(
        totalCount = this.totalCount,
        pageableCount = this.pageableCount,
        isEnd = this.isEnd,
        items = this.items.map { it.mapToItem() }
    )
}