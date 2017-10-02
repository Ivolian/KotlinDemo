package com.ivotai.kotlindemo.movie

import com.ivotai.kotlindemo.movie.view.MovieAct
import dagger.Subcomponent


@Subcomponent(modules = arrayOf(MovieModule::class))
interface MovieComponent {
        fun inject(a:MovieAct)
}