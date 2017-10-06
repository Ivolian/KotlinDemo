package com.ivotai.kotlindemo.train.presenter

import com.ivotai.kotlindemo.app.base.presenter.BasePresenter
import com.ivotai.kotlindemo.movie.model.respository.TrainRepository
import com.ivotai.kotlindemo.train.view.TrainView
import io.reactivex.rxkotlin.plusAssign


class TrainPresenter(private var view: TrainView, private var repository: TrainRepository) : BasePresenter() {

    override fun onViewCreated() {
        subscriptions += loadTrains()
    }

    private val name = "G4"

    private fun loadTrains() = repository.get(name).subscribe { view.render(it) }

}