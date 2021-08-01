package com.example.assignmentproject.di

import com.example.assignmentproject.framework.presentation.MainActivity
import com.example.assignmentproject.framework.presentation.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Vinit Saxena on 01/08/21.
 */
@Module

abstract class ActivityBuilderDI {
    @ContributesAndroidInjector(
        modules = [
            InteractorDI::class,
            ViewModelDI::class
        ]
    )
    abstract fun provideSplashActivity(): SplashActivity

    @ContributesAndroidInjector(
        modules = [
            InteractorDI::class,
            ViewModelDI::class
        ]
    )
    abstract fun provideMainActivity(): MainActivity
}