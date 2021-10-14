package com.example.studysample_01.data.model

import com.example.studysample_01.domain.entity.EntityMapper
import com.example.studysample_01.domain.entity.BookSearchEntity

object BookSearchMapper : EntityMapper<BookSearchEntity, BookSearchModel>() {

    override fun fromEntityModel(searchEntity: BookSearchEntity): BookSearchModel {
        return BookSearchModel(
            totalCount = searchEntity.totalCount,
            pageableCount = searchEntity.pageableCount,
            isEnd = searchEntity.isEnd,
            items = searchEntity.items.map { BookInfoMapper.fromEntityModel(it) }
        )
    }

    override fun fromModelEntity(searchModel: BookSearchModel): BookSearchEntity {

        return BookSearchEntity(
            totalCount = searchModel.totalCount,
            pageableCount = searchModel.pageableCount,
            isEnd = searchModel.isEnd,
            items = searchModel.items.map { BookInfoMapper.fromModelEntity(it) }
        )
    }
}