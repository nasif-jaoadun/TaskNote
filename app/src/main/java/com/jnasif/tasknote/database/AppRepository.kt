package com.jnasif.tasknote.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.jnasif.tasknote.utilities.SampleDataCreatorUtility
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppRepository(application : Application) {
    private val mDb = AppDatabase.getInstance(application.applicationContext).taskNoteDao()
    lateinit var mTaskNote : LiveData<List<TaskNoteEntity>>

    init {
        CoroutineScope(Dispatchers.IO).launch {
            addSampleData()
        }
    }
    fun addSampleData(){
        mDb.insertAllTaskNotes(SampleDataCreatorUtility.getTaskNotes())
        mTaskNote = getAllTaskNotes()
    }

    fun getAllTaskNotes() : LiveData<List<TaskNoteEntity>>{
        return mDb.getAll()
    }

    fun deleteAllData() {
        mDb.deleteAll()
    }
}