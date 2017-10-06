package com.ivotai.kotlindemo.app.dagger

import com.ivotai.kotlindemo.app.App
import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.entity.MyObjectBox
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import javax.inject.Singleton


@Module
class BoxModule(val app: App) {

    @Singleton
    @Provides
    fun boxStore(): BoxStore = MyObjectBox.builder().androidContext(app).build()

    @Singleton
    @Provides
    fun movieBox(boxStore: BoxStore): Box<Movie> = boxStore.boxFor(Movie::class.java)

}