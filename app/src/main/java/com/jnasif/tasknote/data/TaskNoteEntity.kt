package com.jnasif.tasknote.data

import java.util.Date

data class TaskNoteEntity (
    val id: Int,
    val createDate: Date,
    val taskNameText: String,
    val taskStatus : Boolean
)