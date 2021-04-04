package com.example.kexamplerecycleview.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplerecycleview.R
import com.example.kexamplerecycleview.model.IImageLoader
import com.example.kexamplerecycleview.model.entity.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NotesRVAdapter (val imageLoader : IImageLoader<ImageView>): RecyclerView.Adapter<NotesRVAdapter.ViewHolder> () {

    var notes: List<Note> = listOf()
    set (value){
        field = value
        notifyDataSetChanged()
    }

    // 0. Определяем CLASS ViewHolder (т.е. только шаблон из чего состоит itemView, для связи с каждым внутр.элементов itemView)
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // На вход конструктор (?) берет переданную Item и разбираем ее на составные части
        // при этом предварительно найти все вьюшки (как в java) здесь не требуется,
        // (но - это расход ресурсов, поэтому нужно как-то закэшировать)
        fun bind(note: Note) {
            itemView.tv_title.text = note.mTitle
            itemView.tv_text.text = note.avatarUrl
            note.avatarUrl?.let { imageLoader.loadInto(it, itemView.iv_avatar) }
            //note.mColor?.let { itemView.setBackgroundColor(it) }

        //      P.S. визуально красивее через with (хотя ... ну, не знаю)
        //        fun bind1(note: Note) = with(itemView){
        //            tv_title.text = note.mTitle
        //            tv_text.text = note.mText
        //            setBackgroundColor(note.mColor)
        }


    }

    // Далее переопределяем ТРИ метода
    // 1. Recycler должен знать сколько у него элементов
    override fun getItemCount(): Int = notes.size

    // 2. Создаем каждую конкретную itemView
    // берем из item-layout из ресорсов и передаем его к новый объект холдера, который разбирает его по частям
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    // 3. Наполняем viewHolder (подставляем в шаблон конкретные значения из Model)
    // holder отделен от данных, т.к. это RecycleView, т.е. переиспользуемые холдеры
    override fun onBindViewHolder(holder: NotesRVAdapter.ViewHolder, position: Int) = holder.bind(
        notes[position]
    )

    fun updateNote(newNotes: List<Note>) {
        this.notes = newNotes
//        notifyDataSetChanged()
    }

}