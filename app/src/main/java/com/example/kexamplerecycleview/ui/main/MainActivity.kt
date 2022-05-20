package com.example.kexamplerecycleview.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplerecycleview.R
import com.example.kexamplerecycleview.model.api.ApiHolder
import com.example.kexamplerecycleview.model.entity.Note
import com.example.kexamplerecycleview.model.repo.retrofit.RetrofitGithubUsersRepo
import io.reactivex.rxjava3.core.Single
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //    если нужен MVVM - то можно забрать пару классов из master ветки git (МainViewModel и MainViewState)

    private val TAG = "MyActivity"
    // 1. ADAPTER создаем
    private val mRvAdapter: NotesRvAdapter by lazy { NotesRvAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        // 2. На "rv в xml" накладываем layout ( можно Grid или любой)
        rv_notes.layoutManager = LinearLayoutManager(this)
        // 3. На "rv в xml" накладываем созданный в п.1 адаптер
        rv_notes.adapter = mRvAdapter


        // ВАРИАНТ 1. передаем данные (которые забрали в моделе) из сохраненных
        // mRVdapter.notes = FakeNotesRepository.getNotes()

        // ВАРИАНТ 2. передаем данные из retrofit request
        val anySingle: Single<List<Note>> = RetrofitGithubUsersRepo(ApiHolder().api).getUsers()
        anySingle.subscribe({
            Log.i(TAG,"--------------------$it")
            mRvAdapter.updateNote(it)
        }, {
            println("onError: ${it.message}")
        })
    }
}