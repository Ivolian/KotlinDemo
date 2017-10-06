package com.ivotai.kotlindemo.movie.model.respository

import com.ivotai.kotlindemo.BuildConfig
import com.ivotai.kotlindemo.train.model.api.TrainApi
import com.ivotai.kotlindemo.train.model.entity.TrainInfo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class TrainRepositoryImpl(private val api: TrainApi) : TrainRepository {

    override fun get(name: String): Observable<TrainInfo> {
        return api.get(BuildConfig.APP_KEY, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.result.train_info }
    }

}