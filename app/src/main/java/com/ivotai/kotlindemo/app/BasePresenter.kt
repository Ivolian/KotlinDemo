package com.ivotai.kotlindemo.app

import io.reactivex.disposables.CompositeDisposable


abstract class BasePresenter :Presenter{

    protected var subscriptions = CompositeDisposable()

    override fun onViewDestroyed(){
        subscriptions.dispose()
    }

}