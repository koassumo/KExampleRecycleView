package com.example.kexamplerecycleview.model.api

import com.example.kexamplerecycleview.model.entity.Note
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IDataSource {
    @GET("/users")
    fun getUsers(): Single<List<Note>>
}