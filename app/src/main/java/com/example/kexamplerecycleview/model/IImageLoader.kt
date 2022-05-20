package com.example.kexamplerecycleview.model

interface IImageLoader <T>{
    fun loadInto (url: String, container: T)
}