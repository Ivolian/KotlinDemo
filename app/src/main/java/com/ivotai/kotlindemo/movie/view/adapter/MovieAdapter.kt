package com.ivotai.kotlindemo.movie.view.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ivotai.kotlindemo.R
import com.ivotai.kotlindemo.movie.model.entity.Movie


class MovieAdapter(data: List<Movie>) : BaseQuickAdapter<Movie, BaseViewHolder>(R.layout.item_movie, data) {

    override fun convert(helper: BaseViewHolder, item: Movie) {
        val imageView = helper.getView<ImageView>(R.id.image)
        Glide.with(mContext).load(item.poster).into(imageView)
    }

}
