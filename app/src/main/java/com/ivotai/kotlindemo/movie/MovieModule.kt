package com.ivotai.kotlindemo.movie

import com.ivotai.kotlindemo.movie.model.api.MovieApi
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.model.respository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class MovieModule{

    @Provides
    fun movieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

    @Provides
    fun movieRepository(movieApi: MovieApi): MovieRepository = MovieRepositoryImpl(movieApi)

}
