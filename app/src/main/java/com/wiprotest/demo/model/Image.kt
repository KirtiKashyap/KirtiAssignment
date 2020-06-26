package com.wiprotest.demo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    @SerializedName("size")
    val size: String,
    @SerializedName("#text")
    val text: String
): Parcelable