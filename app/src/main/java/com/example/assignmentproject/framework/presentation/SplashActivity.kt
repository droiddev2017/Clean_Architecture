package com.example.assignmentproject.framework.presentation

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.assignmentproject.R
import com.example.assignmentproject.framework.util.hide
import com.example.assignmentproject.framework.util.visible
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

/**
 * Created by Vinit Saxena on 01/08/21.
 */
class SplashActivity : BaseActivity<SplashViewModel>() {

    @Inject
    lateinit var splashViewModelFactory: SplashViewModelFactory

    override fun getLayoutId(): Int = R.layout.activity_splash


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btn_update.setOnClickListener {
            progress.visible()
            mViewModel.updateWhenVersionChange(et_version.text.toString().toInt())
        }

        mViewModel.viewStateLiveData.observe(this, {
            progress.hide()
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        })
    }

    override fun getVM(): SplashViewModel {
        return ViewModelProviders.of(this, splashViewModelFactory).get(SplashViewModel::class.java)
    }
}