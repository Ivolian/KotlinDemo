package com.ivotai.kotlindemo.data


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApi {

    @GET("index")
    fun get(@Query(value = "key") appKey: String,
            @Query(value = "title") title: String): Observable<Response<Movie>?>

}