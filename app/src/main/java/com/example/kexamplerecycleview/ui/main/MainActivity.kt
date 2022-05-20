package com.example.kexamplerecycleview.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kexamplerecycleview.R
import com.example.kexamplerecycleview.databinding.ActivityMainBinding
import com.example.kexamplerecycleview.model.api.ApiHolder
import com.example.kexamplerecycleview.model.entity.Note
import com.example.kexamplerecycleview.model.repo.retrofit.RetrofitGithubUsersRepo
import io.reactivex.rxjava3.core.Single


class MainActivity : AppCompatActivity() {

    //    если нужен MVVM - то можно забрать пару классов из master ветки git (МainViewModel и MainViewState)

    // 1. ADAPTER создаем
    private val mRvAdapter: NotesRvAdapter by lazy { NotesRvAdapter() }

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(getLayoutInflater())
        val view = binding.getRoot()
        setContentView(view)

    //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        // 2. На "rv в xml" накладываем layout ( можно Grid или любой)
        binding.rvNotes.layoutManager = LinearLayoutManager(this)
        // 3. На "rv в xml" накладываем созданный в п.1 адаптер
        binding.rvNotes.adapter = mRvAdapter


        // ВАРИАНТ 1. передаем данные (которые забрали в моделе) из сохраненных
        // mRVdapter.notes = FakeNotesRepository.getNotes()

        // ВАРИАНТ 2. передаем данные из retrofit request
        val anySingle: Single<List<Note>> = RetrofitGithubUsersRepo(ApiHolder().api).getUsers()
        anySingle.subscribe({
            Log.i("TAG","--------------------$it")
            mRvAdapter.updateNote(it)
        }, {
            println("onError: ${it.message}")
        })
    }
}