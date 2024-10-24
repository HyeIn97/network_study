package com.example.data.di

import com.example.data.datasource.SearchDataSource
import com.example.data.repositoryImpl.SearchRepositoryImpl
import com.example.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providerSearchRepository(searchDataSource: SearchDataSource): SearchRepository = SearchRepositoryImpl(searchDataSource)
}
