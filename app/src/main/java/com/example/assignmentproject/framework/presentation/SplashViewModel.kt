package com.example.assignmentproject.framework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.assignmentproject.business.interactors.SyncData
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

/**
 * Created by Vinit Saxena on 01/08/21.
 */
class SplashViewModel(private val syncData: SyncData) : BaseViewModel() {

    private val liveData = MutableLiveData<SplashState>()
    val viewStateLiveData : LiveData<SplashState> = liveData;
    fun updateWhenVersionChange(version: Int) {
        viewModelScope.launch(Main) {
            syncData.updateFakeServerData(version)
            liveData.value = SplashState.GoToMain
        }
    }
}
sealed class SplashState{
    object GoToMain : SplashState()
}