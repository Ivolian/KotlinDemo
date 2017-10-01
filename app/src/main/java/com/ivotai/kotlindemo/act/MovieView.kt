package com.ivotai.kotlindemo.act

import com.ivotai.kotlindemo.data.Movie


interface MovieView {

    fun showRefresh()
    fun showError()
    fun stopRefresh()
    fun render(movies: List<Movie>)

}