package com.example.kexamplerecycleview.model.repo.retrofit

import com.example.kexamplerecycleview.model.api.IDataSource
import com.example.kexamplerecycleview.model.repo.IGithubUsersRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


data class RetrofitGithubUsersRepo(val api: IDataSource) : IGithubUsersRepo {
    override fun getUsers() = api.getUsers()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}