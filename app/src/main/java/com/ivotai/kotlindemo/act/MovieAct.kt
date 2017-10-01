package com.ivotai.kotlindemo.act

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ivotai.kotlin.AppComponentHolder
import com.ivotai.kotlindemo.R
import com.ivotai.kotlindemo.adapter.MovieAdapter
import com.ivotai.kotlindemo.app.Info
import com.ivotai.kotlindemo.data.Movie
import com.ivotai.kotlindemo.data.MovieService
import com.ivotai.kotlindemo.data.Response
import com.ivotai.kotlindemo.dependency.bindView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieAct : AppCompatActivity(), MovieActBehavior {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppComponentHolder.appComponent.inject(this)
        setContentView(R.layout.act_movie)
        getMovies()
    }

    @Inject
    lateinit var movieApi: MovieApi

    override fun getMovies() {


        val title = "哥斯拉"
        movieApi.get(Info.APP_KEY, title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<Movie>> {
                    override fun onError(e: Throwable) {
                        ""
                    }

                    override fun onComplete() {
                        ""
                    }

                    override fun onSubscribe(d: Disposable) {
                        ""
                    }

                    override fun onNext(t: Response<Movie>) {
                        renderMovies(t.result)
                    }
                })


    }

    private val recycleView: RecyclerView by bindView(R.id.recyclerView)

    override fun renderMovies(movies: List<Movie>) {
        with(recycleView) {
            layoutManager = LinearLayoutManager(this@MovieAct)
            adapter = MovieAdapter(movies)
        }
    }


}
