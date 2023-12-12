package com.jnasif.tasknote.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName= "taskNotes")
data class TaskNoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val createDate: Date,
    val taskNameText: String,
    val taskDone : Boolean
)