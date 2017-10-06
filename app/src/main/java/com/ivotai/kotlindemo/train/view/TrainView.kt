package com.ivotai.kotlindemo.train.view

import com.ivotai.kotlindemo.train.model.entity.TrainInfo

interface TrainView {

    fun render(trainInfo: TrainInfo)

}