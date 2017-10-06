package com.ivotai.kotlindemo.movie.inject

import com.ivotai.kotlindemo.movie.model.respository.TrainRepository
import com.ivotai.kotlindemo.movie.model.respository.TrainRepositoryImpl
import com.ivotai.kotlindemo.train.model.api.TrainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class TrainModule {

    @TrainScope
    @Provides
    fun trainApi(retrofit: Retrofit): TrainApi = retrofit.create(TrainApi::class.java)

    @TrainScope
    @Provides
    fun trainRepository(api: TrainApi): TrainRepository = TrainRepositoryImpl(api)

}
