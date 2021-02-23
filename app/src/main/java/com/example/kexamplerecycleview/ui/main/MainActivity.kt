package com.example.kexamplerecycleview.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplerecycleview.ApiHolder
import kotlinx.android.synthetic.main.activity_main.*
import com.example.kexamplerecycleview.R
import com.example.kexamplerecycleview.model.NotesRepSecond
import com.example.kexamplerecycleview.model.NotesRepository
import com.example.kexamplerecycleview.model.entity.Note
import com.example.kexamplerecycleview.model.repo.retrofit.RetrofitGithubUsersRepo
import io.reactivex.rxjava3.core.Single


class MainActivity : AppCompatActivity() {

    //    если нужен MVVM - то можно забрать пару классов из master ветки git (МainViewModel и MainViewState)
    //    lateinit var viewModel: MainViewModel

    lateinit var mRVdapter: NotesRVAdapter
    lateinit var uRepo: List<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        val anySingle: Single<List<Note>> = RetrofitGithubUsersRepo(ApiHolder().api).getUsers()
        anySingle?.subscribe({ s ->
            println(s)
            mRVdapter.updateNote(s)
        }, {
            println("onError: ${it.message}")
        })

//
//        RetrofitGithubUsersRepo(ApiHolder().api).getUsers()
//            .observeOn(mainThreadScheduler)
//            .subscribe({ s ->
//                println(s)
//
//                //mRVdapter.newNotes(NotesRepository.getNotes())
//            }, {
//                println("onError: ${it.message}")
//            })


        // 1.1. ADAPTER создаем
        mRVdapter = NotesRVAdapter()
        // 1.2. передаем данные (которые забрали в моделе)
        mRVdapter.notes = NotesRepository.getNotes()

        // 1.3. накладываем адаптер на recycle
        rv_notes.adapter = mRVdapter

        // 2.1. LAYOUT создаем (!!! можно Grid или любой) и 2.2. накладываем layout на recycler
        rv_notes.layoutManager = LinearLayoutManager(this)

        //mRVdapter.updateNote(NotesRepSecond.getNotes())

//        viewModel.getViewState().observe(this, Observer { value ->
//            value?.let {
//                adapter.notes = it.notes
//            }
//        })
    }







}