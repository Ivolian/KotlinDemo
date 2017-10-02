package com.ivotai.kotlin

import com.ivotai.kotlindemo.movie.MovieComponent
import com.ivotai.kotlindemo.movie.MovieModule
import dagger.Component


@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun getMovieComponent(module: MovieModule): MovieComponent

}