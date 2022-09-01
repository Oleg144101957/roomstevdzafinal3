package com.example.roomstevdzafinal3.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roomstevdzafinal3.Const
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = Const.TABLE_NAME)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String
) : Parcelable