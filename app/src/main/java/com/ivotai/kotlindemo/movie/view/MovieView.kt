package com.ivotai.kotlindemo.movie.view

import com.ivotai.kotlindemo.movie.model.entity.Movie


interface MovieView {

    fun showRefresh()
    fun stopRefresh()
    fun showError()
    fun render(movies: List<Movie>)

}