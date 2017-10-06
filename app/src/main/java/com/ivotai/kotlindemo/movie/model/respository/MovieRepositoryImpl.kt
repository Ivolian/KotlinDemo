package com.ivotai.kotlindemo.movie.model.respository

import com.ivotai.kotlindemo.movie.model.entity.Movie
import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Observable


class MovieRepositoryImpl(private val box: Box<Movie>) : MovieRepository {

    override fun get(): Observable<List<Movie>> = RxQuery.observable(box.query().build())

}