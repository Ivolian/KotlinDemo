package com.ivotai.kotlindemo.act

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ivotai.kotlin.AppComponentHolder
import com.ivotai.kotlindemo.adapter.MovieAdapter
import com.ivotai.kotlindemo.app.Info
import com.ivotai.kotlindemo.data.Movie
import com.ivotai.kotlindemo.data.MovieService
import com.ivotai.kotlindemo.data.Response
import org.jetbrains.anko.setContentView
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

class MovieAct(private val actUi: MovieActUi = MovieActUi()) : AppCompatActivity(), MovieActBehavior {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppComponentHolder.appComponent.inject(this)
        actUi.setContentView(this)
        getMovies()
    }

    @Inject
    lateinit var movieService: MovieService

    override fun getMovies() {
        loadingNow()
        val title = "哥斯拉"
        movieService.get(Info.APP_KEY, title).enqueue(object : Callback<Response<Movie>> {
            override fun onResponse(call: Call<Response<Movie>>, response: retrofit2.Response<Response<Movie>>) {
                loadingFinish()
                response.body()?.result?.let { renderMovies(it) }
            }

            override fun onFailure(call: Call<Response<Movie>>, t: Throwable) {
                loadingFail()
            }
        })
    }

    override fun renderMovies(movies: List<Movie>) {
        with(actUi.rvMovie) {
            layoutManager = LinearLayoutManager(this@MovieAct)
            adapter = MovieAdapter(movies)
        }
    }

    override fun loadingNow() {
        actUi.tvStatus.text = "加载电影中..."
    }

    override fun loadingFinish() {
        actUi.tvStatus.text = "加载完成"
    }

    override fun loadingFail() {
        actUi.tvStatus.text = "加载失败"
    }

}
