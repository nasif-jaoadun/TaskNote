package com.jnasif.tasknote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TaskNoteEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskNote() : TaskNoteDao
    companion object{
        val DATABASE_NAME = "AppDatabase.db"
        @Volatile
        private lateinit var instance : AppDatabase

        fun getInstance(context : Context) : AppDatabase{
            if (instance == null){
                synchronized(this){
                    if(instance == null){
                        instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
                    }
                }
            }
            return instance
        }

    }
}