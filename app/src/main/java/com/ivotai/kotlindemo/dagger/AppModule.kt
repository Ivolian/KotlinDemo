package com.ivotai.kotlin

import com.ivotai.kotlindemo.app.Info
import com.ivotai.kotlindemo.data.MovieService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class AppModule {

    @Provides
    fun retrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(Info.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun movieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

}