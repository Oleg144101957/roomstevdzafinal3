package com.example.roomstevdzafinal3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomstevdzafinal3.models.Note


@Database(entities = [Note::class], exportSchema = true, version = 1)
abstract class NoteDB : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object{

        @Volatile
        var INSTANCE: NoteDB? = null

        fun getNoteDatabase(context: Context) : NoteDB {

            val temp = INSTANCE
            if (temp != null) return temp

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDB::class.java,
                    "DB_NAME"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}