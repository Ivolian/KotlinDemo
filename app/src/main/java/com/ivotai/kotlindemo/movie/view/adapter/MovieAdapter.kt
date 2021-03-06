package com.ivotai.kotlindemo.movie.view.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.ivotai.kotlindemo.R
import com.ivotai.kotlindemo.app.base.view.BVH
import com.ivotai.kotlindemo.movie.model.entity.Movie
import kotlinx.android.synthetic.main.item_movie.*


class MovieAdapter : BaseQuickAdapter<Movie, BVH>(R.layout.item_movie) {

    override fun convert(holder: BVH, movie: Movie) {
        holder.tvName.text = movie.name
    }

}
