package com.ivotai.kotlindemo.act

import com.ivotai.kotlindemo.data.Movie


interface MovieActBehavior {

    fun getMovies()

    fun renderMovies(movies:List<Movie>)


}