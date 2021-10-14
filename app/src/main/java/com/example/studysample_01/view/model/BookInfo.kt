package com.example.studysample_01.view.model

import com.example.studysample_01.domain.entity.BookInfoEntity

data class BookInfo(
    val author: String?,        // 저자
    val description: String?,   // 책 설명
    val title: String,          // 제목
    val image: String,          // 이미지
    val price: String? = null   // 가격
)

fun BookInfoEntity.mapToItem() : BookInfo = BookInfo(
    author = this.author,
    description = this.description,
    title = this.title,
    image = this.title,
    price = this.price
)