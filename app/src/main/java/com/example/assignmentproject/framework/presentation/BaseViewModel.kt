package com.example.assignmentproject.framework.presentation

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.assignmentproject.framework.presentation.AssignmentApplication

/**
 * Created by Vinit Saxena on 31/07/21.
 */
open class BaseViewModel : AndroidViewModel(AssignmentApplication.INSTANCE) {
    protected val isProgress = MutableLiveData<Boolean>()
    protected val error = MutableLiveData<Throwable>()
}