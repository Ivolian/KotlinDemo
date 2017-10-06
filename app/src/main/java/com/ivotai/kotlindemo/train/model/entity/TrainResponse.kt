package com.ivotai.kotlindemo.train.model.entity


class TrainResponse(
        val resultcode: String, //200
        val reason: String, //Successed!
        val result: Result,
        val error_code: Int //0
)

class Result(
        val train_info: TrainInfo
)

class TrainInfo(
        val name: String, //G656
        val start: String, //西安北
        val end: String, //北京西
        val starttime: String, //10:10
        val endtime: String, //16:27
        val mileage: String //1212km
)

