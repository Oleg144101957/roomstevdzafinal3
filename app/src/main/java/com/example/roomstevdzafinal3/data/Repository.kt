package com.example.roomstevdzafinal3.data

import androidx.lifecycle.LiveData
import com.example.roomstevdzafinal3.models.Note

class Repository(val noteDao: NoteDao) {

    fun readAllNotes(): LiveData<List<Note>>{
        return noteDao.readAllNotes()
    }

    fun addNote(note: Note){
        noteDao.addNote(note)
    }

    fun updateNote(note: Note){
        noteDao.updateNote(note)
    }

    fun deleteNote(note: Note){
        noteDao.deleteNote(note)
    }

}