package com.ivotai.kotlindemo.app.dagger

import com.ivotai.kotlin.AppModule
import com.ivotai.kotlindemo.movie.dagger.MovieComponent
import dagger.Component


@App
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun getMovieComponent(): MovieComponent

}