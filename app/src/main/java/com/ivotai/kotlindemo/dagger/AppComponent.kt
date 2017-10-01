package com.ivotai.kotlin

import com.ivotai.kotlindemo.movie.view.MovieAct
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(movieAct: MovieAct)
}