package com.ivotai.kotlindemo.app.inject

import com.ivotai.kotlindemo.app.App
import com.ivotai.kotlindemo.app.inject.scope.AppScope
import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.entity.MyObjectBox
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore


@Module
class BoxModule(val app: App) {

    @AppScope
    @Provides
    fun boxStore(): BoxStore = MyObjectBox.builder().androidContext(app).build()

    @AppScope
    @Provides
    fun movieBox(boxStore: BoxStore): Box<Movie> = boxStore.boxFor(Movie::class.java)

}