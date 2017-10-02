package com.ivotai.kotlindemo.movie.presenter

import com.ivotai.kotlindemo.base.BasePresenter
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.view.MovieView
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy


class MoviePresenter(private var view: MovieView, private var repository: MovieRepository) : BasePresenter() {

    private val defaultTitle = "哥斯拉"
    private var title = defaultTitle

    fun onViewCreated() {
        loadMovies(title)
    }

    fun onRefresh() {
        loadMovies(title)
    }

    fun onSearchChanged(title: String) {
        this.title =title
        loadMovies(title)
    }

    private fun loadMovies(title: String) = with(view) {
        showRefresh()
        subscriptions += repository.getMovies(title).subscribeBy(
                onNext = { it.result.let { render(it) } },
                onError = { showError() },
                onComplete = { stopRefresh() }
        )
    }

}