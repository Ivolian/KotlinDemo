package com.ivotai.kotlin

import com.google.gson.Gson
import com.ivotai.kotlindemo.app.Info
import com.ivotai.kotlindemo.data.MovieApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
class AppModule {

    @Provides
    fun okHttpClient(): OkHttpClient =  OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
//            .addInterceptor(makeHeadersInterceptor())
//            .addInterceptor(makeAddSecurityQueryInterceptor())
//            .addInterceptor(makeLoggingInterceptor())
            .build()

//    fun makeHeadersInterceptor() = Interceptor { chain -> // 1
//        chain.proceed(chain.request().newBuilder()
//                .addHeader("Accept", "application/json")
//                .addHeader("Accept-Language", "en")
//                .addHeader("Content-Type", "application/json")
//                .build())

//    fun makeLoggingInterceptor() = HttpLoggingInterceptor().apply {
//        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
//        else HttpLoggingInterceptor.Level.NONE
//    }

    @Provides
    fun retrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(Info.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    fun movieService(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

}