package com.ivotai.kotlindemo.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.*


class MovieAdapterUi : AnkoComponent<ViewGroup> {

    lateinit var tvTitle:TextView

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = dip(48))
                orientation = LinearLayout.HORIZONTAL
                tvTitle = textView {
                    text = "he"
                    textSize = 16f
                }
            }
        }
    }

}