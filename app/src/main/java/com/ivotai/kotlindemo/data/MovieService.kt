package com.ivotai.kotlindemo.data


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieService {

    @GET("index")
    fun get(@Query(value = "key") appKey: String,
            @Query(value = "title") title: String): Call<Response<Movie>>

}