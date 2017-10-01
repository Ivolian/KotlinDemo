package com.ivotai.kotlindemo

import com.ivotai.kotlindemo.act.MovieView
import com.ivotai.kotlindemo.data.Movie
import com.ivotai.kotlindemo.data.Response
import com.ivotai.kotlindemo.respository.MovieRepositoryImpl
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class MoviePresenter(private var movieView: MovieView, private var movieRepository: MovieRepositoryImpl) {

    fun onCreate() {
        movieView.showRefresh()
        getMovies()
    }

    fun onRefresh() {
        getMovies()
    }

    fun getMovies() = with(movieView) {
        movieRepository.getMovies(
                "哥斯拉"
        )
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
                        t?.result?.let {  render(it) }
                    }
                })
    }

}