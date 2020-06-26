package com.wiprotest.demo.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OpensearchQuery(
    @SerializedName("role")
    val role: String,
    @SerializedName("searchTerms")
    val searchTerms: String,
    @SerializedName("startPage")
    val startPage: String,
    @SerializedName("#text")
    val text: String
): Parcelable