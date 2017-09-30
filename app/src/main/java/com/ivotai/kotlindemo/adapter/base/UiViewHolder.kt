package com.ivotai.kotlindemo.adapter.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext


class UiViewHolder<out AdapterUi : AnkoComponent<ViewGroup>>(parent: ViewGroup, val ui: AdapterUi)
    : RecyclerView.ViewHolder(ui.createView(AnkoContext.Companion.create(parent.context, parent)))