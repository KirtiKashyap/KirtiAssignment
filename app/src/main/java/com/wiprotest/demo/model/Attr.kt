package com.wiprotest.demo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Attr(
    @SerializedName("for")
    val forX: String
): Parcelable