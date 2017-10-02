package com.ivotai.kotlin

import com.ivotai.kotlindemo.movie.MovieComponent
import com.ivotai.kotlindemo.movie.MovieModule
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import dagger.Component


@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
//    fun inject2(movieAct: MovieAct)
    fun getMovieRep(): MovieRepository

    fun userComponent(module: MovieModule): MovieComponent
}