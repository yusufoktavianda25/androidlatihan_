package binar.academy.roomsample.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Student (
    @PrimaryKey(autoGenerate = true) var id:Int?,
    @ColumnInfo(name="nama") var nama :String,
    @ColumnInfo(name="email") var email :String,
        ):Parcelable