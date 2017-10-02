package com.ivotai.kotlindemo.movie.model.entity

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@SuppressLint("ParcelCreator")
@Parcelize
class Movie(
        val movieid: String, //10641
        val rating: String, //7.3
        val genres: String, //动作/惊悚/科幻
        val runtime: String, //139 min
        val language: String, //英语/法语/日语
        val title: String, //哥斯拉
        val poster: String, //http://v.juhe.cn/movie/img?5146
        val writers: String, //迪安·德夫林,罗兰·艾默里奇,...
        val film_locations: String, //美国
        val directors: String, //罗兰·艾默里奇
        val rating_count: String, //3191
        val actors: String, //马修·布罗德里克 Matthew Broderick,让·雷诺 Jean Reno,玛丽亚·皮提罗 Maria Pitillo,汉克·阿扎利亚 Hank Azaria
        val plot_simple: String, //一道亮光划过天际，太平洋上波涛汹涌，海浪以不可思议的速度将一架货机卷入海里；巴哈马丛林中，出现了巨大的脚印；一股神秘的力量一直朝纽约而来，这座人口稠密的都市即将受到这个怪兽“哥斯拉”的袭击。“哥斯拉”是因为核试验造成气..
        val year: String, //1998
        val country: String, //美国
        val type: String, //null
        val release_date: String, //19980518
        val also_known_as: String //酷斯拉怪兽哥斯拉
) : Parcelable