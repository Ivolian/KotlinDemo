package com.ivotai.kotlindemo.movie.model.respository

import com.ivotai.kotlindemo.BuildConfig
import com.ivotai.kotlindemo.base.Response
import com.ivotai.kotlindemo.movie.model.api.MovieApi
import com.ivotai.kotlindemo.movie.model.entity.Movie
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MovieRepositoryImpl(private val movieApi: MovieApi) : MovieRepository {

    override fun getMovies(title: String): Observable<Response<Movie>> =
            movieApi.getMovies(BuildConfig.APP_KEY, title)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

}