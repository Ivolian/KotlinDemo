package com.ivotai.kotlindemo.app.dagger

import com.ivotai.kotlin.AppModule
import com.ivotai.kotlindemo.movie.dagger.MovieComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class, BoxModule::class))
interface AppComponent {

    fun getMovieComponent(): MovieComponent

}