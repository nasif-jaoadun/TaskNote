package com.jnasif.tasknote

import android.util.Log
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jnasif.tasknote.database.AppDatabase
import com.jnasif.tasknote.database.TaskNoteDao
import com.jnasif.tasknote.utilities.SampleDataCreatorUtility
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    val TAG = "Junit_Testing"
    private lateinit var mDb : AppDatabase
    private lateinit var mDao : TaskNoteDao

    @Before
    fun createDb(){
        var context = InstrumentationRegistry.getInstrumentation().context
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        mDao = mDb.taskNote()
        Log.i(TAG, "createDb")
    }

    @After
    fun closeDb(){
        mDb.close()
        Log.i(TAG, "closeDb")
    }

    @Test
    fun createAndRetrieveTaskNotes(){
        mDao.insertAllTaskNotes(SampleDataCreatorUtility.getTaskNotes())
        var count = mDao.getCount()
        Log.i(TAG, "createAndRetrieveTaskNotes : count = ${count}")
        assertEquals(SampleDataCreatorUtility.getTaskNotes().size , count)
    }

    @Test
    fun compareString(){
        mDao.insertAllTaskNotes(SampleDataCreatorUtility.getTaskNotes())
        val original = SampleDataCreatorUtility.getTaskNotes().get(0)
        val fromDb = mDao.getTaskNoteById(1)
        assertEquals(original.taskNameText, fromDb.taskNameText)
        assertEquals(1, fromDb.id)
    }
}