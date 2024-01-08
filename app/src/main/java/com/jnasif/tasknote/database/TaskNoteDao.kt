package com.jnasif.tasknote.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskNoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTaskNote(taskNoteEntity : TaskNoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTaskNotes(taskNoteS : List<TaskNoteEntity>)

    @Delete
    fun deleteTaskNote(taskNoteEntity : TaskNoteEntity)

    @Query("SELECT * FROM taskNotes where id = :id")
    fun getTaskNoteById(id : Int) : TaskNoteEntity

    @Query("SELECT * FROM taskNotes ORDER BY createDate DESC")
    fun getAll() : LiveData<List<TaskNoteEntity>>

    @Query("DELETE FROM taskNotes")
    fun deleteAll() : Int

    @Query("SELECT COUNT(*) from taskNotes")
    fun getCount() : Int
}