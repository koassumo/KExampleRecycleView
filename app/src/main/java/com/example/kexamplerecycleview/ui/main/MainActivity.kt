package com.example.kexamplerecycleview.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.example.kexamplerecycleview.R
import com.example.kexamplerecycleview.model.NotesRepository

class MainActivity : AppCompatActivity() {

    //    если нужен MVVM - то можно забрать пару классов из master ветки git (МainViewModel и MainViewState)
    //    lateinit var viewModel: MainViewModel

    lateinit var mRVdapter: NotesRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        // 1.1. ADAPTER создаем
        mRVdapter = NotesRVAdapter()
        // 1.2. передаем данные (которые забрали в моделе)
        mRVdapter.notes = NotesRepository.getNotes()
        // 1.3. накладываем адаптер на recycle
        rv_notes.adapter = mRVdapter

        // 2.1. LAYOUT создаем (!!! можно Grid или любой) и 2.2. накладываем layout на recycler
        rv_notes.layoutManager = LinearLayoutManager(this)



//        viewModel.getViewState().observe(this, Observer { value ->
//            value?.let {
//                adapter.notes = it.notes
//            }
//        })
    }








//    fun initRV (){
//
//
//// эта часть, по идее, должна быть в Model, но ХЗ как getApplicationContext() в Модель перенести
//        val myDataArray: Array<Note> = arrayOf<Note>(
//            Note(
//                ContextCompat.getDrawable(applicationContext, R.drawable.z_clear_sky_white),
//                "Ясно", false
//            ),
//            Note(
//                ContextCompat.getDrawable(applicationContext, R.drawable.z_cloud_broken_white),
//                "Переменная облачность", false
//            ),
//            Note(
//                ContextCompat.getDrawable(applicationContext, R.drawable.z_cloud_few_white),
//                "Облачно", false
//            ),
//            Note(
//                ContextCompat.getDrawable(applicationContext, R.drawable.z_cloud_overcast_white),
//                "Пасмурно", false
//            ),
//            Note(
//                ContextCompat.getDrawable(applicationContext, R.drawable.z_foggy_white),
//                "Туман", false
//            ),
//            Note(
//                ContextCompat.getDrawable(applicationContext, R.drawable.z_night_clear_sky_white),
//                "Ясная ночь", false
//            ),
//            Note(
//                ContextCompat.getDrawable(applicationContext, R.drawable.z_snow_white),
//                "Снег", false
//            ),
//            Note(
//                ContextCompat.getDrawable(applicationContext, R.drawable.z_thunder_white),
//                "Гроза", false
//            )
//        )
//
//
//
//// отсюда собственно код инициации Ресайкла
//// Toast.makeText(getApplicationContext(), "lksdfj", Toast.LENGTH_LONG).show();
//
//        // создаем (находим) recycle
//        val myRecyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
//
//        // создаем адаптер, передаем данные
//        //val myAdapter = NotesRVAdapter(myDataArray)
//
//        // создаем Layout
//        val myLinearLayoutManager = LinearLayoutManager(applicationContext)
//                                                //   или (getBaseContext());
//
//        // накладываем адаптер на recycle
//        myRecyclerView.setAdapter(NotesRVAdapter)
//
//        // накладываем layout на recycle
//        myRecyclerView.layoutManager = myLinearLayoutManager
//
//    }
}