package com.ivotai.kotlin

import com.ivotai.kotlindemo.movie.MovieComponent
import com.ivotai.kotlindemo.movie.MovieModule

object AppComponentHolder {

    val appComponent: AppComponent by lazy { DaggerAppComponent.builder().appModule(AppModule()).build() }

    val movieCom: MovieComponent by lazy { appComponent.userComponent(MovieModule()) }

}
