package com.ivotai.kotlindemo.movie.view

import com.ivotai.kotlindemo.movie.model.entity.Movie


interface MovieView {

    fun render(movies: List<Movie>)

}