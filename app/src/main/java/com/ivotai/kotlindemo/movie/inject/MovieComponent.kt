package com.ivotai.kotlindemo.movie.inject

import com.ivotai.kotlindemo.app.DataGenerator
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = arrayOf(MovieModule::class))
interface MovieComponent {
    fun inject(a: DataGenerator)
    fun getMovieRepository(): MovieRepository
}