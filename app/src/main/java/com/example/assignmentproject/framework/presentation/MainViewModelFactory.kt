package com.example.assignmentproject.framework.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentproject.business.interactors.DisplayNames

/**
 * Created by Vinit Saxena on 01/08/21.
 */
class MainActivityViewModelFactory constructor(private val displayNames: DisplayNames) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(displayNames) as T
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
            }
        }

    }

}