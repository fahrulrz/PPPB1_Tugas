package com.example.recycleviewfilm
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val filmTitle: String="",
    val duration: String="",
    val genre: String="",
    val ageRating: String="",
    val cover: Int,
    val synopsis: String=""
) : Parcelable
