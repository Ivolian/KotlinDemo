package com.ivotai.kotlindemo.movie.view

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.ivotai.kotlin.AppComponentHolder
import com.ivotai.kotlindemo.R
import com.ivotai.kotlindemo.base.BaseAct
import com.ivotai.kotlindemo.dependencies.bindView
import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.presenter.MoviePresenter
import com.ivotai.kotlindemo.movie.view.adapter.MovieAdapter
import javax.inject.Inject


class MovieAct : BaseAct(), MovieView {

    override val layoutResId = R.layout.act_movie

    override fun injectDependencies() {
        AppComponentHolder.appComponent.inject(this)
    }

    @Inject lateinit var repository: MovieRepository
    private lateinit var presenter: MoviePresenter

    private val recycleView: RecyclerView by bindView(R.id.recyclerView)
    private val swipeRefreshLayout: SwipeRefreshLayout by bindView(R.id.swipeRefreshLayout)

    override fun init() {
        presenter = MoviePresenter(this, repository)
        presenter.onViewCreated()
        swipeRefreshLayout.setOnRefreshListener { presenter.onRefresh() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

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
        with(recycleView) {
            layoutManager = LinearLayoutManager(this@MovieAct)
            adapter = MovieAdapter(movies)
        }
    }

}
