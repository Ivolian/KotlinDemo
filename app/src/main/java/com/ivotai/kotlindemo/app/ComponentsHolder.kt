package com.ivotai.kotlindemo.app

import com.ivotai.kotlindemo.app.dagger.AppComponent
import com.ivotai.kotlindemo.app.dagger.DaggerAppComponent
import com.ivotai.kotlindemo.movie.dagger.MovieComponent


object ComponentsHolder {

    private val appComponent: AppComponent by lazy { DaggerAppComponent.create() }

    val movieComponent: MovieComponent by lazy { appComponent.getMovieComponent() }

}
