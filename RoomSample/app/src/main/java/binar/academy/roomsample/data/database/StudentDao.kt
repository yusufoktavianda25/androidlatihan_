package binar.academy.roomsample.data.database

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import binar.academy.roomsample.data.Student

@Dao
interface StudentDao {
    @Query("SELECT * FROM Student")
    fun getAllStudent():List<Student>

    @Insert(onConflict = REPLACE)
    fun insertStudent(student: Student):Long

    @Update
    fun updateStudent(student: Student):Int

    @Delete
    fun deleteStudent(student: Student):Int

}