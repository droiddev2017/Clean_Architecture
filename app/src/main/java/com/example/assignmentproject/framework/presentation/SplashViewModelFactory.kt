package com.example.assignmentproject.framework.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentproject.business.interactors.SyncData

/**
 * Created by Vinit Saxena on 01/08/21.
 */
class SplashViewModelFactory constructor(private val syncData: SyncData) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> {
                SplashViewModel(syncData) as T
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
            }
        }

    }

}