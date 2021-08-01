package com.example.assignmentproject.di

import android.content.Context
import com.example.assignmentproject.business.data.cache.abstraction.CacheDataSource
import com.example.assignmentproject.business.data.cache.implementation.CacheDataSourceImpl
import com.example.assignmentproject.framework.datasource.cache.abstraction.LocalCacheService
import com.example.assignmentproject.framework.datasource.cache.implementation.LocalDataServiceImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 01/08/21.
 */
@Module
class CacheModule {
    @Provides
    @Singleton
    fun provideCacheSource(cacheService: LocalCacheService): CacheDataSource {
        return CacheDataSourceImpl(cacheService)
    }

    @Provides
    @Singleton
    fun provideCacheLocalService(context: Context, gson: Gson): LocalCacheService {
        return LocalDataServiceImpl(context, gson)
    }
}
