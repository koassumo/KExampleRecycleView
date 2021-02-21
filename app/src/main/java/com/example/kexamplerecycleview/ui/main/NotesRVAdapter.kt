package com.example.kexamplerecycleview.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*
import com.example.kexamplerecycleview.R
import com.example.kexamplerecycleview.model.entity.Note

class NotesRVAdapter : RecyclerView.Adapter<NotesRVAdapter.ViewHolder> () {
//    private var myDataArray: ArrayList<Note>
//    private val context: Context? = null
//    private const val selectedPosition = -1
//    private val onItemClickListener: OnItemClickListener? = null

    var notes: List <Note> = listOf()
    set (value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent,false))

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NotesRVAdapter.ViewHolder, position: Int) = holder.bind(notes[position])

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(note: Note) {
            itemView.tv_title.text = note.mTitle
            itemView.tv_text.text = note.mText
            //itemView.setBackgroundColor(note.mColor)
        }

//      визуально красивее (хм ... ну, не знаю)
//        fun bind1(note: Note) = with(itemView){
//            tv_title.text = note.mTitle
//            tv_text.text = note.mText
//            setBackgroundColor(note.mColor)
//        }


    }



}