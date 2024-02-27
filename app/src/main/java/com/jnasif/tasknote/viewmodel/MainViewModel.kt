package com.jnasif.tasknote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jnasif.tasknote.database.TaskNoteEntity
import com.jnasif.tasknote.utilities.SampleDataCreatorUtility

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val mTaskNote : List<TaskNoteEntity> = SampleDataCreatorUtility.getTaskNotes()
}