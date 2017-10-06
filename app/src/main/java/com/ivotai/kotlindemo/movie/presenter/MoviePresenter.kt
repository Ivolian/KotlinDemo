package com.ivotai.kotlindemo.movie.presenter

import com.ivotai.kotlindemo.base.BasePresenter
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.view.MovieView


class MoviePresenter(private var view: MovieView, private var repository: MovieRepository) : BasePresenter() {

    fun onViewCreated() {
        loadMovies()
    }

    fun onRefresh() {
        loadMovies()
    }

    private fun loadMovies() = repository.get().subscribe { view.render(it) }

}