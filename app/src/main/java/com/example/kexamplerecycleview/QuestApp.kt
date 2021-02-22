package com.example.kexamplerecycleview

import android.app.Application
import com.example.kexamplerecycleview.model.apiData.QuestApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class QuestApp: Application() {

    lateinit var questApi: QuestApp

    override fun onCreate() {
        super.onCreate()

        configureRetrofit()

    }

    private fun configureRetrofit() {
        val httpLoggingIntercepter = HttpLoggingInterceptor()
        httpLoggingIntercepter.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingIntercepter)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        questApi = retrofit.create(QuestApi::class.java)

    }

}