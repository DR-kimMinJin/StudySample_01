package com.example.studysample_01.di

import com.example.studysample_01.data.BookKeywordSendRepositoryImpl
import com.example.studysample_01.data.BookRemoteDataSource
import com.example.studysample_01.data.BookRemoteDataSourceImpl
import com.example.studysample_01.data.remote.BookSearchRepositoryImpl
import com.example.studysample_01.domain.BookKeywordSendRepository
import com.example.studysample_01.domain.BookSearchRepository
import com.example.studysample_01.utils.ServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// TODO : Provides 구현
@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun providerBookDataSource(serviceApi: ServiceApi): BookRemoteDataSource {
        return BookRemoteDataSourceImpl(serviceApi)
    }

    @Provides
    fun providerBookSearch(bookRemoteDataSource: BookRemoteDataSource): BookSearchRepository {
        return BookSearchRepositoryImpl(bookRemoteDataSource)
    }

    @Provides
    fun providerBookKeywordSend(): BookKeywordSendRepository {
        return BookKeywordSendRepositoryImpl()
    }

}