package com.example.kexamplerecycleview.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kexamplerecycleview.model.NotesRepository

class MainViewModel: ViewModel () {
    private val viewStateLiveData = MutableLiveData <MainViewState>()

    init {
        viewStateLiveData.value = MainViewState(NotesRepository.getNotes())
    }

    fun getViewState(): LiveData<MainViewState> = viewStateLiveData

//    fun buttonClick (){
//        model.riseCounter
//    }
}