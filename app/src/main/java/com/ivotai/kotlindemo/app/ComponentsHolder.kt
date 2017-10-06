package com.ivotai.kotlindemo.app

import com.ivotai.kotlin.NetworkModule
import com.ivotai.kotlindemo.app.inject.BoxModule
import com.ivotai.kotlindemo.app.inject.component.DaggerAppComponent


object ComponentsHolder {

    private lateinit var app: App

    fun init(app: App) {
        ComponentsHolder.app = app
    }

    private val appComponent by lazy {
        DaggerAppComponent.builder()
                .networkModule(NetworkModule())
                .boxModule(BoxModule(app))
                .build()
    }

    val movieComponent by lazy {
        appComponent.getMovieComponent()
    }


    val trainComponent by lazy {
        appComponent.getTrainComponent()
    }

}