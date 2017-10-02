package com.ivotai.kotlindemo.movie.presenter

import com.ivotai.kotlindemo.app.BasePresenter
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.view.MovieView
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy


class MoviePresenter(private var view: MovieView, private var repository: MovieRepository) : BasePresenter() {

    fun onViewCreated() {
        view.showRefresh()
        loadMovies()
    }

    fun onRefresh() {
        loadMovies()
    }

    private fun loadMovies() = with(view) {
        subscriptions += repository.getMovies("哥斯拉").subscribeBy(
                onNext = { it.result.let { render(it) } },
                onError = { showError() },
                onComplete = { stopRefresh() }
        )
    }

}