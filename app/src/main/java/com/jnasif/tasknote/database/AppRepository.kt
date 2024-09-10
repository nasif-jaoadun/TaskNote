package com.jnasif.tasknote.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.jnasif.tasknote.utilities.SampleDataCreatorUtility
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppRepository(application : Application) {
    private val mDb = AppDatabase.getInstance(application.applicationContext).taskNoteDao()
    lateinit var mTaskNote : LiveData<List<TaskNoteEntity>>
    private val executor : Executor = Executors.newSingleThreadExecutor()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            addSampleData()
        }
    }
    fun addSampleData(){
        executor.execute(Runnable {
            mDb.insertAllTaskNotes(SampleDataCreatorUtility.getTaskNotesWithoutID())
            mTaskNote = getAllTaskNotes()
        })
    }

    fun getAllTaskNotes() : LiveData<List<TaskNoteEntity>>{
        return mDb.getAll()
    }

    fun deleteAllData() {
        executor.execute(Runnable {
            mDb.deleteAll()
        })
    }

    fun getTaskNoteById(taskNoteId: Int): TaskNoteEntity {
        return mDb.getTaskNoteById(taskNoteId)
    }

    fun insertTaskNote(taskNote: TaskNoteEntity) {
        executor.execute(Runnable { mDb.insertTaskNote(taskNote) })
    }
}