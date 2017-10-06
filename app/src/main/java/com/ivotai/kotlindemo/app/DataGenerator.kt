package com.ivotai.kotlindemo.app

import com.ivotai.kotlindemo.movie.model.entity.Movie
import io.objectbox.Box
import javax.inject.Inject


class DataGenerator {

    @Inject
    lateinit var box: Box<Movie>

    fun generateMovies() {
        box = ComponentsHolder.movieComponent.getBox()
        box.removeAll()
        box.put(listOf(Movie(name = "好看的电影"), Movie(name = "有趣的电影")))
    }

}