package binar.academy.challengefourth.data.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import binar.academy.challengefourth.data.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note")
    fun getAllStudent(): List<Note>

    @Insert(onConflict = REPLACE)
    fun insertStudent(student: Note):Long

    @Update
    fun updateStudent(student: Note):Int

    @Delete
    fun deleteStudent(student: Note):Int
}