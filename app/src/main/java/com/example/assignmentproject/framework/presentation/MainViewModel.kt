package com.example.assignmentproject.framework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.assignmentproject.business.interactors.DisplayNames
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Created by Vinit Saxena on 01/08/21.
 */
class MainViewModel(private val displayNames: DisplayNames) : BaseViewModel() {

    private val liveData = MutableLiveData<MainState>()
    val viewStateLiveData: LiveData<MainState> = liveData;

    init {
        getNames()
    }

    fun getNames() {
        viewModelScope.launch(Main) {
            val list = displayNames.getData()
            liveData.value = MainState.ShowData(list)
        }
    }
}

sealed class MainState {
    data class ShowData(val name: List<String>) : MainState()
}