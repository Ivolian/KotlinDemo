package com.ivotai.kotlindemo.app.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseAct : AppCompatActivity() {

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        injectDependencies()
        init()
    }

    abstract val layoutResId: Int

    abstract fun injectDependencies()

    abstract fun init()

}