package com.example.kexamplerecycleview.model.apiData

import io.reactivex.Single
import retrofit2.http.GET

interface QuestApi {
    @GET("./pokedex/kanto/")
    fun getUsers(): Single<QuestListResponse>
}