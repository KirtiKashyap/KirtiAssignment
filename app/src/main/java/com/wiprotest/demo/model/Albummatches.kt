package com.wiprotest.demo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Albummatches(
    @SerializedName("album")
    val album: List<Album>
) : Parcelable