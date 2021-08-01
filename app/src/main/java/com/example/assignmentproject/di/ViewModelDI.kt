package com.example.assignmentproject.di

import com.example.assignmentproject.business.interactors.DisplayNames
import com.example.assignmentproject.business.interactors.SyncData
import com.example.assignmentproject.framework.presentation.MainActivityViewModelFactory
import com.example.assignmentproject.framework.presentation.SplashViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 01/08/21.
 */
@Module
class ViewModelDI {

    @Provides
    fun provideSplashVMFactory(syncData: SyncData): SplashViewModelFactory =
        SplashViewModelFactory(syncData)

    @Provides
    fun provideMainVMFactory(displayNames: DisplayNames): MainActivityViewModelFactory =
        MainActivityViewModelFactory(displayNames)
}