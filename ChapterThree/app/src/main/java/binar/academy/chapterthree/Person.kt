package binar.academy.chapterthree

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class PersonSerializable (
    val name : String,
    val email : String,
    val address : String,
    val age : String
):Serializable

/**
 * 1. buat login page dimana ada 4 inputan user (username, email, age, address)
 * 2. buat home page
 * 3. kirim data username dari login page ke homepage dengan data class : serializeable
 * 4. terima datanya di homepage berdasarkan keynya
 */
@Parcelize
data class PersonParcelable (
    val name : String,
    val email : String,
    val address : String,
    val age : String
): Parcelable