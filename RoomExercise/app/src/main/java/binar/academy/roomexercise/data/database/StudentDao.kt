package binar.academy.roomexercise.data.database

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import binar.academy.roomexercise.data.Student

@Dao
interface StudentDao {
    @Query("Select * From student")
    fun getAllStudent():List<Student>
    @Insert(onConflict = REPLACE)
    fun insertStudent(student: Student):Long

    @Update
    fun updateStudent(student: Student):Int

    @Delete
    fun deleteStudent(student: Student):Int

}