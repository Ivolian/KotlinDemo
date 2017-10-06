package com.ivotai.kotlindemo.movie.model.respository

import com.ivotai.kotlindemo.train.model.entity.TrainResponse
import io.reactivex.Observable


interface TrainRepository {

     fun get(name:String): Observable<TrainResponse>

}
