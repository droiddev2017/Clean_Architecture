package com.example.assignmentproject.framework.presentation

import android.app.Application
import com.example.assignmentproject.di.AppModule
import com.example.assignmentproject.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by Vinit Saxena on 31/07/21.
 */
class AssignmentApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    companion object {

        lateinit var INSTANCE: AssignmentApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build().inject(this);


    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}