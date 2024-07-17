package binar.academy.roomexercise.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Student(
        @PrimaryKey(autoGenerate = true) var id :Int?,
        @ColumnInfo(name = "nama") var name : String,
        @ColumnInfo(name = "email") var email: String
):Parcelable