package com.example.kexamplerecycleview.model.entity

import android.graphics.drawable.Drawable
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Note(

    @Expose
    @SerializedName ("login")
    var mTitle: String? = null,

    @Expose
    @SerializedName ("id")
    var mText: String? = null,

    @Expose
    @SerializedName ("avatar_url")
    val avatarUrl: String? = null,

    //var mDrawable: Drawable? = null,
    //var mColor: Int? = null,
    //var isChecked: Boolean = false
): Parcelable

//
//@Parcelize
//class GithubUser(
//    @Expose
//    val id: String,
//
//    @Expose val login : String,
//    @Expose val avatarUrl: String? = null,
//    @Expose val reposUrl: String? = null
//): Parcelable