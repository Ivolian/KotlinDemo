package com.ivotai.kotlindemo.base

import android.view.View
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.extensions.LayoutContainer


class BVH(view: View) : BaseViewHolder(view), LayoutContainer {

    override val containerView: View? = itemView

}