package com.example.assignmentproject.framework.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.assignmentproject.R
import com.example.assignmentproject.framework.util.hide
import com.example.assignmentproject.framework.util.visible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.progress
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {

    @Inject
    lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progress.visible()
        mViewModel.viewStateLiveData.observe(this, {
            tv_data.text = (it as? MainState.ShowData)?.name.toString()
            progress.hide()
        })
    }

    override fun getVM(): MainViewModel {
        return ViewModelProviders.of(this, mainActivityViewModelFactory)
            .get(MainViewModel::class.java)
    }


}