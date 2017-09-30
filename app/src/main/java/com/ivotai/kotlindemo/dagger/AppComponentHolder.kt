package com.ivotai.kotlin

object AppComponentHolder {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule()).build()
    }

}
