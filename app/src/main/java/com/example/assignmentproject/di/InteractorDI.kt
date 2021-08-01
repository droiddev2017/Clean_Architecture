package com.example.assignmentproject.di

import com.example.assignmentproject.business.data.cache.abstraction.CacheDataSource
import com.example.assignmentproject.business.data.network.abstraction.NetworkDataSource
import com.example.assignmentproject.business.interactors.DisplayNames
import com.example.assignmentproject.business.interactors.SyncData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 01/08/21.
 */

@Module
class InteractorDI {
//    @Singleton
//    @Provides
//    fun provideDisplayName(cacheDataSource: CacheDataSource): DisplayNames =
//        DisplayNames(cacheDataSource)

//    @Provides
//    @Singleton
//    fun provideSyncData(
//        cacheDataSource: CacheDataSource,
//        networkDataSource: NetworkDataSource
//    ): SyncData =
//        SyncData(cacheDataSource, networkDataSource)
}