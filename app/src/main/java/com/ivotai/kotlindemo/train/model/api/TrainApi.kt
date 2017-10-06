package com.ivotai.kotlindemo.train.model.api

import com.ivotai.kotlindemo.train.model.entity.TrainResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TrainApi {

    @GET("s")
    fun get(@Query(value = "key") appKey: String,
            @Query(value = "name") name: String): Observable<TrainResponse>

}