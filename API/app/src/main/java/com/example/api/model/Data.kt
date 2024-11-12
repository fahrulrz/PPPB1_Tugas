package com.example.api.model

import android.os.Parcelable
import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    @SerializedName("id")
    val id : Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("avatar")
    val avatar: String
) : Parcelable
