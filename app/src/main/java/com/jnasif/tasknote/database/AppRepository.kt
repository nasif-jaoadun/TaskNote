package com.jnasif.tasknote.database

import android.app.Application
import com.jnasif.tasknote.utilities.SampleDataCreatorUtility
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppRepository(application : Application) {
    private val mDb = AppDatabase.getInstance(application.applicationContext).taskNoteDao()
    var mTaskNote : List<TaskNoteEntity> = SampleDataCreatorUtility.getTaskNotes()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            addSampleData()
        }
    }
    fun addSampleData(){
        mDb.insertAllTaskNotes(SampleDataCreatorUtility.getTaskNotes())
    }
}