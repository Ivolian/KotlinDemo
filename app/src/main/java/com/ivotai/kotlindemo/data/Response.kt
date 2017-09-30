package com.ivotai.kotlindemo.data


class Response<out T>(
        val resultcode: String, //200
        val reason: String, //成功的返回
        val result: List<T>,
        val error_code: Int //0
)