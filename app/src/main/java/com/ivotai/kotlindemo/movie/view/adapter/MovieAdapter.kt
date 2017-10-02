package com.ivotai.kotlindemo.movie.view.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ivotai.kotlindemo.R
import com.ivotai.kotlindemo.base.BVH
import com.ivotai.kotlindemo.movie.model.entity.Movie
import kotlinx.android.synthetic.main.item_movie.*


class MovieAdapter : BaseQuickAdapter<Movie, BVH>(R.layout.item_movie) {

    override fun convert(helper: BVH, item: Movie) {
        Glide.with(mContext).load(item.poster).into(helper.image)
    }

}
