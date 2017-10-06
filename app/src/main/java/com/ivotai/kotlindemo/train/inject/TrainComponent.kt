package com.ivotai.kotlindemo.movie.inject

import com.ivotai.kotlindemo.movie.model.respository.TrainRepository
import dagger.Subcomponent


@TrainScope
@Subcomponent(modules = arrayOf(TrainModule::class))
interface TrainComponent {
    fun getTrainRepository(): TrainRepository
}