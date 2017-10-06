package com.ivotai.kotlindemo.movie.model.respository

import com.ivotai.kotlindemo.movie.model.entity.Movie
import io.reactivex.Observable


interface MovieRepository {

     fun getMovies(title:String): Observable<List<Movie>>


}
