package com.ivotai.kotlindemo.movie.model.respository

import com.ivotai.kotlindemo.app.base.model.Repository
import com.ivotai.kotlindemo.train.model.entity.TrainInfo
import io.reactivex.Observable


interface TrainRepository : Repository {

    fun get(name: String): Observable<TrainInfo>

}
