package com.example.composeunsplash.data.api


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("download")
    val download: String,
    @SerializedName("download_location")
    val downloadLocation: String,
    @SerializedName("html")
    val html: String,
    @SerializedName("self")
    val self: String
)