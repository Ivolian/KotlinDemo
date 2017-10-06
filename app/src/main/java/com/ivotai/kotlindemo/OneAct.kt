package com.ivotai.kotlindemo

import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.ivotai.kotlindemo.app.ComponentsHolder
import com.ivotai.kotlindemo.base.BaseAct
import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.model.respository.TrainRepository
import com.ivotai.kotlindemo.movie.presenter.MoviePresenter
import com.ivotai.kotlindemo.movie.view.MovieView
import com.ivotai.kotlindemo.movie.view.adapter.MovieAdapter
import com.ivotai.kotlindemo.train.model.entity.TrainInfo
import com.ivotai.kotlindemo.train.presenter.TrainPresenter
import com.ivotai.kotlindemo.train.view.TrainView
import kotlinx.android.synthetic.main.act_one.*
import javax.inject.Inject


class OneAct : BaseAct(), MovieView, TrainView {


    // ===== override =====

    override val layoutResId = R.layout.act_one

    override fun injectDependencies() {
        movieRepository = ComponentsHolder.movieComponent.getMovieRepository()
        trainRepository = ComponentsHolder.trainComponent.getTrainRepository()
    }


    // ===== presenter =====

    @Inject lateinit var movieRepository: MovieRepository
    private val moviePresenter by lazy { MoviePresenter(this, movieRepository) }
    @Inject lateinit var trainRepository: TrainRepository
    private val trainPresenter by lazy { TrainPresenter(this, trainRepository) }


    // ===== init =====

    private val movieAdapter = MovieAdapter()

    override fun init() {

        // init recyclerView
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@OneAct)
            adapter = movieAdapter
        }

        // movie interaction
        swipeRefreshLayout.setOnRefreshListener { moviePresenter.onRefresh() }
        moviePresenter.onViewCreated()

        // train interaction
        trainPresenter.onViewCreated()
    }


    // ===== onDestroy =====

    override fun onDestroy() {
        super.onDestroy()
        moviePresenter.onViewDestroyed()
        trainPresenter.onViewDestroyed()
    }


    // ===== trainView =====

    override fun render(trainInfo: TrainInfo) {
        tvTrainInfo.text = trainInfo.name
    }


    // ===== movieView =====

    override fun showRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun stopRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showError() {
        Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show()
    }

    override fun render(movies: List<Movie>) {
        movieAdapter.setNewData(movies)
    }

}
