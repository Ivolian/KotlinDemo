package com.ivotai.kotlindemo.movie.model.api


import com.ivotai.kotlindemo.app.Response
import com.ivotai.kotlindemo.movie.model.entity.Movie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApi {

    @GET("index")
    fun getMovies(@Query(value = "key") appKey: String,
                  @Query(value = "title") title: String): Observable<Response<Movie>>

}