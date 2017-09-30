package com.ivotai.kotlindemo.adapter.base

import android.view.ViewGroup
import com.chad.library.adapter.base.BaseViewHolder
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext


class UiViewHolder<out AdapterUi : AnkoComponent<ViewGroup>>(parent: ViewGroup, val ui: AdapterUi)
    : BaseViewHolder(ui.createView(AnkoContext.Companion.create(parent.context, parent)))