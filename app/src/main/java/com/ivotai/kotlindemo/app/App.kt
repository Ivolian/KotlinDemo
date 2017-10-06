package com.ivotai.kotlindemo.app

import android.app.Application


class App:Application(){

    override fun onCreate() {
        super.onCreate()
        ComponentsHolder.init(this)

        DataGenerator().generateMovies()
    }

}
