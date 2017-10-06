package com.ivotai.kotlindemo.movie.model.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
class Movie(
        @Id var id: Long = 0,
        var name: String
)