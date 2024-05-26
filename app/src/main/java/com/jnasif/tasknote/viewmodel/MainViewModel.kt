package com.jnasif.tasknote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.jnasif.tasknote.database.AppRepository
import com.jnasif.tasknote.database.TaskNoteEntity
import com.jnasif.tasknote.utilities.SampleDataCreatorUtility

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val mRepository = AppRepository(application) // bari bari bari bari
    var mTaskNote : LiveData<List<TaskNoteEntity>> = mRepository.mTaskNote

    fun addSampleData() {
        mRepository.addSampleData()
    }

    fun deleteAllData() {
        mRepository.deleteAllData()
    }
}