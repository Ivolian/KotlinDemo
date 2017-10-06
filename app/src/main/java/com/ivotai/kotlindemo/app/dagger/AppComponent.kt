package com.ivotai.kotlindemo.app.dagger

import com.ivotai.kotlin.NetworkModule
import com.ivotai.kotlindemo.movie.inject.MovieComponent
import com.ivotai.kotlindemo.movie.inject.TrainComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(NetworkModule::class, BoxModule::class))
interface AppComponent {

    fun getMovieComponent(): MovieComponent
    fun getTrainComponent(): TrainComponent

}