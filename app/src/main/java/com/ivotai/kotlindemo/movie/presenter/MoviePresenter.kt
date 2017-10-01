package com.ivotai.kotlindemo.movie.presenter

import com.ivotai.kotlindemo.app.Response
import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.view.MovieView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class MoviePresenter(private var movieView: MovieView, private var movieRepository: MovieRepository) {

    fun onCreate() {
        movieView.showRefresh()
        getMovies()
    }

    fun onRefresh() {
        getMovies()
    }

    private fun getMovies() = with(movieView) {
        movieRepository.getMovies("哥斯拉")
                .subscribe(object : Observer<Response<Movie>?> {
                    override fun onError(e: Throwable) {
                        showError()
                    }

                    override fun onComplete() {
                        stopRefresh()
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: Response<Movie>) {
                        t.result.let {  render(it) }
                    }
                })
    }

}