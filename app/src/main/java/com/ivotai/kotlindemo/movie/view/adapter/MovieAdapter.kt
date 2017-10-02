package com.ivotai.kotlindemo.movie.view.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ivotai.kotlindemo.R
import com.ivotai.kotlindemo.base.BaseViewHolderK
import com.ivotai.kotlindemo.movie.model.entity.Movie
import kotlinx.android.synthetic.main.item_movie.*


class MovieAdapter : BaseQuickAdapter<Movie, BaseViewHolderK>(R.layout.item_movie) {

    override fun convert(helper: BaseViewHolderK, item: Movie) {
        Glide.with(mContext).load(item.poster).into(helper.image)
    }

}
