package com.example.assignmentproject.framework.presentation

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * Created by Vinit Saxena on 31/07/21.
 */
abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    protected val mViewModel: VM by lazy {
        getVM()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun getVM(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        performInjection()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    protected fun performInjection() {
        AndroidInjection.inject(this);
    }
}