package com.example.roomstevdzafinal3.presantation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomstevdzafinal3.data.NoteDB
import com.example.roomstevdzafinal3.data.Repository
import com.example.roomstevdzafinal3.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val mLiveData: LiveData<List<Note>>
    val repo: Repository

    init {
        val noteDao = NoteDB.getNoteDatabase(application).getNoteDao()
        repo = Repository(noteDao)
        mLiveData = repo.readAllNotes()
    }

    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addNote(note)
        }
    }

    fun updateNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateNote(note)
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteNote(note)
        }
    }
}