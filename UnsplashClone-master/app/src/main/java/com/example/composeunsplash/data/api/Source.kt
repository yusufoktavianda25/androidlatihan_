package com.example.composeunsplash.data.api


import com.example.composeunsplash.data.api.Ancestry
import com.example.composeunsplash.data.api.CoverPhoto
import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("ancestry")
    val ancestry: Ancestry,
    @SerializedName("cover_photo")
    val coverPhoto: CoverPhoto,
    @SerializedName("description")
    val description: String,
    @SerializedName("meta_description")
    val metaDescription: String,
    @SerializedName("meta_title")
    val metaTitle: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)