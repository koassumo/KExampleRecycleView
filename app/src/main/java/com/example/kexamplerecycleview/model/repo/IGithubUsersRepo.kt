package com.example.kexamplerecycleview.model.repo

import com.example.kexamplerecycleview.model.entity.Note
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<Note>>
}