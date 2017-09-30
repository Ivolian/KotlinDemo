package com.ivotai.kotlindemo.act

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MovieActUi : AnkoComponent<MovieAct> {

    lateinit var tvStatus: TextView
    lateinit var rvMovie: RecyclerView

    override fun createView(ui: AnkoContext<MovieAct>) = with(ui) {

        verticalLayout {
            tvStatus = textView {
                backgroundColor = Color.GREEN
                setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)
                gravity = Gravity.CENTER
            }.lparams(width = matchParent, height = dip(100))
            rvMovie = recyclerView()
        }

    }

}