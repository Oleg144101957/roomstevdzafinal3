package com.example.roomstevdzafinal3.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomstevdzafinal3.Const
import com.example.roomstevdzafinal3.models.Note


@Dao
interface NoteDao {

    @Query("SELECT * FROM ${Const.TABLE_NAME}")
    fun readAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

}