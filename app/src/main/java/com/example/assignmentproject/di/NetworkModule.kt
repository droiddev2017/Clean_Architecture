package com.example.assignmentproject.di

import android.content.Context
import com.example.assignmentproject.business.data.network.abstraction.NetworkDataSource
import com.example.assignmentproject.business.data.network.implementation.NetworkDataSourceImpl
import com.example.assignmentproject.framework.datasource.network.abstraction.NetworkService
import com.example.assignmentproject.framework.datasource.network.implementation.NetworkServiceImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 01/08/21.
 */
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideNetworkSource(networkService: NetworkService): NetworkDataSource {
        return NetworkDataSourceImpl(networkService)
    }

    @Provides
    @Singleton
    fun provideNetworkService(context: Context, gson: Gson): NetworkService {
        return NetworkServiceImpl(context, gson)
    }
}