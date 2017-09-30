package com.ivotai.kotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ivotai.kotlindemo.adapter.base.UiViewHolder
import com.ivotai.kotlindemo.data.Movie

class MovieAdapter(private var movies: List<Movie>) : RecyclerView.Adapter<UiViewHolder<MovieAdapterUi>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UiViewHolder<MovieAdapterUi> {
        return UiViewHolder(parent, MovieAdapterUi())
    }

    override fun onBindViewHolder(holder: UiViewHolder<MovieAdapterUi>, position: Int) {
        val movie = movies[position]
        with(holder.ui) {
            tvTitle.text = movie.title
        }
    }

    override fun getItemCount(): Int = movies.size

}


