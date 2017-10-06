package com.ivotai.kotlindemo.movie.inject.module

import com.ivotai.kotlindemo.movie.inject.scope.MovieScope
import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.model.respository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import io.objectbox.Box


@Module
class MovieModule {

    @MovieScope
    @Provides
    fun movieRepository(box: Box<Movie>): MovieRepository = MovieRepositoryImpl(box)

}
