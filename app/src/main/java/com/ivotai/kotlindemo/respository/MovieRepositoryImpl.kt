package com.ivotai.kotlindemo.respository

import com.ivotai.kotlindemo.app.Info
import com.ivotai.kotlindemo.data.Movie
import com.ivotai.kotlindemo.data.MovieApi
import com.ivotai.kotlindemo.data.Response
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val movieApi: MovieApi) {

     fun getMovies(title: String): Observable<Response<Movie>?> =
            movieApi.get(Info.APP_KEY, title)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())


}