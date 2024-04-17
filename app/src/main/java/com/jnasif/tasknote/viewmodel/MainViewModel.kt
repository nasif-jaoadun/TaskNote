package com.jnasif.tasknote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jnasif.tasknote.database.AppRepository
import com.jnasif.tasknote.database.TaskNoteEntity
import com.jnasif.tasknote.utilities.SampleDataCreatorUtility

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val mRepository = AppRepository(application)
    var mTaskNote : List<TaskNoteEntity> = mRepository.mTaskNote
}