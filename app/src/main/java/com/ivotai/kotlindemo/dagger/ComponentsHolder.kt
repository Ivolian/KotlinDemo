package com.ivotai.kotlin

import com.ivotai.kotlindemo.movie.MovieComponent
import com.ivotai.kotlindemo.movie.MovieModule

object ComponentsHolder {

    private val appComponent: AppComponent by lazy { DaggerAppComponent.builder().appModule(AppModule()).build() }

    val movieComponent: MovieComponent by lazy { appComponent.getMovieComponent(MovieModule()) }

}
