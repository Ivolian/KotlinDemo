package com.ivotai.kotlindemo.train.presenter

import com.ivotai.kotlindemo.base.BasePresenter
import com.ivotai.kotlindemo.movie.model.respository.TrainRepository
import com.ivotai.kotlindemo.train.view.TrainView

class TrainPresenter(private var view: TrainView, private var repository: TrainRepository) : BasePresenter() {

    fun onViewCreated() {
        loadTrains()
    }

    private fun loadTrains() = repository.get("G4").subscribe {
        view.render(it.result.train_info)
    }

}