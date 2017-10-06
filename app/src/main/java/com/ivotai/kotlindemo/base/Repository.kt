package com.ivotai.kotlindemo.base

import io.reactivex.Observable

interface Repository<T> {

    fun get(query: String): Observable<List<T>>

}