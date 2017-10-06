package com.ivotai.kotlindemo.movie.dagger

import com.ivotai.kotlindemo.app.DataGenerator
import com.ivotai.kotlindemo.movie.view.MovieAct
import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = arrayOf(MovieModule::class))
interface MovieComponent {
    fun inject(a: MovieAct)
    fun inject(a: DataGenerator)
}