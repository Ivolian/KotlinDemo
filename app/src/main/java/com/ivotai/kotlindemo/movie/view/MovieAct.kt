package com.ivotai.kotlindemo.movie.view

import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.ivotai.kotlin.ComponentsHolder
import com.ivotai.kotlindemo.R
import com.ivotai.kotlindemo.base.BaseAct
import com.ivotai.kotlindemo.movie.model.entity.Movie
import com.ivotai.kotlindemo.movie.model.respository.MovieRepository
import com.ivotai.kotlindemo.movie.presenter.MoviePresenter
import com.ivotai.kotlindemo.movie.view.adapter.MovieAdapter
import kotlinx.android.synthetic.main.act_movie.*
import javax.inject.Inject


class MovieAct : BaseAct(), MovieView {

    override val layoutResId = R.layout.act_movie

    override fun injectDependencies() {
        ComponentsHolder.movieComponent.inject(this)
    }

    @Inject lateinit var movieRepository: MovieRepository
    private val moviePresenter by lazy { MoviePresenter(this, movieRepository) }

    override fun init() {
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@MovieAct)
            adapter = movieAdapter
        }
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                moviePresenter.onSearchChanged(p0.toString())
            }
        })
        swipeRefreshLayout.setOnRefreshListener { moviePresenter.onRefresh() }
        moviePresenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        moviePresenter.onViewDestroyed()
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

    private val movieAdapter by lazy { MovieAdapter() }

    override fun render(movies: List<Movie>) {
        movieAdapter.setNewData(movies)
    }

}
