package com.jnasif.tasknote.database

import com.jnasif.tasknote.utilities.SampleDataCreatorUtility

class AppRepository {
    var mTaskNote : List<TaskNoteEntity> = SampleDataCreatorUtility.getTaskNotes()
    private var appRepository = AppRepository()
    fun getInstance(): AppRepository {
        return appRepository
    }
}