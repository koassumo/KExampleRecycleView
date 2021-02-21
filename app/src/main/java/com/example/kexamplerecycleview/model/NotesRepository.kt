package com.example.kexamplerecycleview.model

import com.example.kexamplerecycleview.model.entity.Note

object NotesRepository {
    private val notes: List<Note> = listOf(
        Note(
            "Первая заметка",
            "lskdfjlksdfj dslfkjds dsfalkjalsdf sskdfj sdlfkjf sadfljk",
            0xfff06292.toInt(),
            false
            ),
        Note(
            "Вторая заметка",
            "ШЩЩЩШШ ммтмтмдымь ывдтьа зуцоцуцуо ваыиваы9овыа",
            0xfff06292.toInt(),
            false
            ),
        Note(
            "Третья заметка",
            "ждл жлдждл жд лопоп ждлыва  ыолвдаав шуццуш лдлоыва ваыдлоывдло дывлао",
            0xfff06292.toInt(),
            false
            ),
        Note(
            "Червертая заметка",
            "ШЩЩЩШШ ммтмтмдымь ывдтьа зуцоцуцуо ваыиваы9овыа",
            0xfff04597.toInt(),
            false
            ),
        Note(
            "Пятая заметка",
            "ццууууу жлдждл жд лопоп ждлыва  ыолвдаав шуццуш лдлоыва ваыдлоывдло дывлаоываыав ваыфв фываыва фываы фыв ф вфыавываыф",
            0xfff06292.toInt(),
            false
            ),
        Note(
            "Шестая заметка",
            "ШЩЩЩШШ ммтмтмдымь ывдтьа зуцоцуцуо ваыиваы9овыа",
            0xfff06292.toInt(),
            false
        ),
        Note(
            "Седьмая заметка",
            "ццууууу жлдждл жд лопоп ждлыва  ыолвдаав шуццуш лдлоыва ваыдлоывдло дывлаоываыав ваыфв фываыва фываы фыв ф вфыавываыф",
            0xfff06292.toInt(),
            false
        )
    )

    fun getNotes (): List<Note> {
        return notes
    }
}