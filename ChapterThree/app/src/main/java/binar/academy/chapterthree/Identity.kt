package binar.academy.chapterthree

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
@Parcelize
data class Identity (
    val name:String,
    val age:Int,
    val address:String,
    val job:String
):Parcelable{

}