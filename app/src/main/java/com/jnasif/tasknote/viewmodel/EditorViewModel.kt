package com.jnasif.tasknote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jnasif.tasknote.database.AppRepository
import com.jnasif.tasknote.database.TaskNoteEntity
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class EditorViewModel(application: Application) : AndroidViewModel(application) {
    private val mRepository = AppRepository(application)
    val mLiveTaskNote : MutableLiveData<TaskNoteEntity> = MutableLiveData()
    private val executpr : Executor = Executors.newSingleThreadExecutor()

    fun loadData(taskNoteId: Int) {
        executpr.execute(Runnable {
            val taskNoteEntity : TaskNoteEntity = mRepository.getTaskNoteById(taskNoteId)
            mLiveTaskNote.postValue(taskNoteEntity)
        })
    }
}