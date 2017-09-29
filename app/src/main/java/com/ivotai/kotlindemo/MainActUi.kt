package com.ivotai.kotlindemo

import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActUi : AnkoComponent<MainAct> {

    override fun createView(ui: AnkoContext<MainAct>) = with(ui) {

        verticalLayout {
            textView {
                backgroundColor = Color.GREEN
                text = "电影"
                setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)
                gravity = Gravity.CENTER
            }.lparams(width = matchParent, height = dip(100))
            recyclerView()
        }

    }

}