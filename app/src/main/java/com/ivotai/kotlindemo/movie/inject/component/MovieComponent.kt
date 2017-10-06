package com.ivotai.kotlindemo.movie.inject.component

import com.ivotai.kotlindemo.movie.inject.scope.MovieScope
import com.ivotai.kotlindemo.movie.inject.module.MovieModule
import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import dagger.Subcomponent
import io.objectbox.Box


@MovieScope
@Subcomponent(modules = arrayOf(MovieModule::class))
interface MovieComponent {
    fun getBox(): Box<Movie>
    fun getRepository(): MovieRepository
}