package com.example.studysample_01.domain.entity

import com.example.studysample_01.domain.Entity

data class BookInfoEntity(
    val author: String?,         // 저자
    val description: String?,    // 책 설명
    val title: String,          // 제목
    val image: String,          // 이미지
    val price: String? = null           // 가격
) : Entity()