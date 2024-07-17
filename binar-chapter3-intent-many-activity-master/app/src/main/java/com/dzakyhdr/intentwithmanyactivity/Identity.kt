package com.dzakyhdr.intentwithmanyactivity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Identity(
    val name: String,
    val usia: Int,
    val alamat: String,
    val pekerjaan: String
): Parcelable
