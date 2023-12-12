package com.jnasif.tasknote.utilities

import com.jnasif.tasknote.database.TaskNoteEntity

class SampleDataCreatorUtility {
    companion object{
        fun getTaskNotes() : List<TaskNoteEntity> {
            val taskNotes = ArrayList<TaskNoteEntity>()
            taskNotes.add(TaskNoteEntity(1, Utility.getDate(0), SAMPLE_TASK_1, false))
            taskNotes.add(TaskNoteEntity(2, Utility.getDate(-1), SAMPLE_TASK_2, false))
            taskNotes.add(TaskNoteEntity(3, Utility.getDate(-2), SAMPLE_TASK_3, false))
            return taskNotes
        }
    }
}