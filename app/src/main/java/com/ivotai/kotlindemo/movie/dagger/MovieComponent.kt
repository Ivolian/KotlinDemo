package com.ivotai.kotlindemo.movie.dagger

import com.ivotai.kotlindemo.movie.view.MovieAct
import dagger.Subcomponent

@Movie
@Subcomponent(modules = arrayOf(MovieModule::class))
interface MovieComponent {
    fun inject(a: MovieAct)
}