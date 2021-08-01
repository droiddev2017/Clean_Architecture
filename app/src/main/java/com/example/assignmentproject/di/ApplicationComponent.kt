package com.example.assignmentproject.di

import android.app.Application
import com.example.assignmentproject.framework.presentation.AssignmentApplication
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 01/08/21.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        CacheModule::class,
        NetworkModule::class,
        ActivityBuilderDI::class
    ]
)
interface ApplicationComponent {
    fun inject(application: AssignmentApplication)

}