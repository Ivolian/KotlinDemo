package com.ivotai.kotlin

import com.ivotai.kotlindemo.act.MovieAct
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(movieAct: MovieAct)
}