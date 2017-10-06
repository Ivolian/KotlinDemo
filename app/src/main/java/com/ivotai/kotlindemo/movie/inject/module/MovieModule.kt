package com.ivotai.kotlindemo.movie.inject.module

import com.ivotai.kotlindemo.movie.inject.scope.MovieScope
import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.model.respository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore


@Module
class MovieModule {

    @MovieScope
    @Provides
    fun box(boxStore: BoxStore): Box<Movie> = boxStore.boxFor(Movie::class.java)

    @MovieScope
    @Provides
    fun repository(box: Box<Movie>): MovieRepository = MovieRepositoryImpl(box)

}
