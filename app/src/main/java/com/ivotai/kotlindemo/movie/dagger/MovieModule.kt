package com.ivotai.kotlindemo.movie.dagger

import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.model.respository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import io.objectbox.Box


@Module
class MovieModule {

//    @MovieScope
//    @Provides
//    fun movieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

    @MovieScope
    @Provides
    fun movieRepository(movieBox: Box<com.ivotai.kotlindemo.movie.model.entity.Movie>): MovieRepository = MovieRepositoryImpl(movieBox)

}
