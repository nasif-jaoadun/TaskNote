package com.jnasif.tasknote.database

import android.app.Application
import androidx.annotation.WorkerThread
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

    fun addSampleData() {
        CoroutineScope(Dispatchers.IO).launch {
            addSampleDataBackEnd()
        }
    }

    fun deleteAllData() {
        CoroutineScope(Dispatchers.IO).launch {
            deleteAll()
        }
    }
    @WorkerThread
    suspend fun addSampleDataBackEnd(){
        mDb.insertAllTaskNotes(SampleDataCreatorUtility.getTaskNotesWithoutID())
        mTaskNote = getAllTaskNotes()
    }

    fun getAllTaskNotes() : LiveData<List<TaskNoteEntity>>{
        return mDb.getAll()
    }

    suspend fun deleteAll() {
        mDb.deleteAll()
    }

    fun getTaskNoteById(taskNoteId: Int): TaskNoteEntity {
        return mDb.getTaskNoteById(taskNoteId)
    }

    suspend fun insertTaskNote(taskNote: TaskNoteEntity) {
        mDb.insertTaskNote(taskNote)
    }

    fun deleteTaskNote(taskNote: TaskNoteEntity?) {
        mDb.deleteTaskNote(taskNote!!)
    }
}