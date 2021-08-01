package com.example.assignmentproject.di

import android.app.Application
import android.content.Context
import com.example.assignmentproject.framework.presentation.AssignmentApplication
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 01/08/21.
 */
@Module
class AppModule(private val application: Application) {

    @Provides
    fun provideContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()
}
