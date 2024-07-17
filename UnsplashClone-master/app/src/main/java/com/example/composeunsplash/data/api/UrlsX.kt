package com.example.composeunsplash.data.api


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UrlsX(
    @SerializedName("small")
    val small: String
):Parcelable