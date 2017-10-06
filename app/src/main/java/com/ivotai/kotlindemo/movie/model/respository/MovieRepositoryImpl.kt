package com.ivotai.kotlindemo.movie.model.respository

import com.ivotai.kotlindemo.movie.model.entity.Movie
import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Observable


class MovieRepositoryImpl(private val movieBox: Box<Movie>) : MovieRepository {

    override fun getMovies(title: String): Observable<List<Movie>> {
        var query = movieBox.query().build()

   return     RxQuery.observable(query);
//        return movieApi.getMovies(BuildConfig.APP_KEY, title)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
    }

}