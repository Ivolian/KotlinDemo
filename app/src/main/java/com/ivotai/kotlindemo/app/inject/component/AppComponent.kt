package com.ivotai.kotlindemo.app.inject.component

import com.ivotai.kotlin.NetworkModule
import com.ivotai.kotlindemo.app.inject.BoxModule
import com.ivotai.kotlindemo.app.inject.scope.AppScope
import com.ivotai.kotlindemo.movie.inject.TrainComponent
import com.ivotai.kotlindemo.movie.inject.component.MovieComponent
import dagger.Component


@AppScope
@Component(modules = arrayOf(NetworkModule::class, BoxModule::class))
interface AppComponent {

    fun getMovieComponent(): MovieComponent
    fun getTrainComponent(): TrainComponent

}