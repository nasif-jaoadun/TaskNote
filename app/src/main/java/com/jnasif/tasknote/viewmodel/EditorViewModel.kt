package com.jnasif.tasknote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jnasif.tasknote.database.AppRepository
import com.jnasif.tasknote.database.TaskNoteEntity

class EditorViewModel(application: Application) : AndroidViewModel(application) {
    private val mRepository = AppRepository(application)
    val mLiveTaskNote : MutableLiveData<TaskNoteEntity> = MutableLiveData()
}