package com.ivotai.kotlindemo.movie.inject

import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.model.respository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import io.objectbox.Box


@Module
class MovieModule {

//    @TrainScope
//    @Provides
//    fun movieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

    @MovieScope
    @Provides
    fun movieRepository(box: Box<Movie>): MovieRepository = MovieRepositoryImpl(box)

}
