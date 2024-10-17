package com.example.data.di

import com.example.data.api.SearchApi
import com.example.data.datasource.SearchDataSource
import com.example.data.datasourceImpl.SearchDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun providerSearchDataSource(searchApi: SearchApi): SearchDataSource = SearchDataSourceImpl(searchApi)
}