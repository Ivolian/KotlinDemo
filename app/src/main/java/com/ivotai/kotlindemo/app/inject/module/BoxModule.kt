package com.ivotai.kotlindemo.app.inject

import com.ivotai.kotlindemo.app.App
import com.ivotai.kotlindemo.app.inject.scope.AppScope
import com.ivotai.kotlindemo.movie.model.entity.MyObjectBox
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore


@Module
class BoxModule(val app: App) {

    @AppScope
    @Provides
    fun boxStore(): BoxStore = MyObjectBox.builder().androidContext(app).build()

}