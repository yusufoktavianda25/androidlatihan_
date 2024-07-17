package com.example.composeunsplash.data.api


import com.example.composeunsplash.data.api.Source
import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)