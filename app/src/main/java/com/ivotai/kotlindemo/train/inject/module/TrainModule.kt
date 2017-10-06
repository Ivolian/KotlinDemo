package com.ivotai.kotlindemo.movie.inject

import com.ivotai.kotlindemo.movie.model.respository.TrainRepository
import com.ivotai.kotlindemo.movie.model.respository.TrainRepositoryImpl
import com.ivotai.kotlindemo.train.model.api.TrainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named


@Module
class TrainModule {

    @TrainScope
    @Provides
    fun api(@Named(value = "train") retrofit: Retrofit): TrainApi = retrofit.create(TrainApi::class.java)

    @TrainScope
    @Provides
    fun repository(api: TrainApi): TrainRepository = TrainRepositoryImpl(api)

}
