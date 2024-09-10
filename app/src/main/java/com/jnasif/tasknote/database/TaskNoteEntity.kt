package com.jnasif.tasknote.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName= "taskNotes")
data class TaskNoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var createDate: Date,
    var taskNameText: String,
    var taskNoteText: String,
    var taskDone : Boolean
)