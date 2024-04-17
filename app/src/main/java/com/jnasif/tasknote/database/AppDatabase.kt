package com.jnasif.tasknote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TaskNoteEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskNoteDao() : TaskNoteDao
    companion object{
        private const val DATABASE_NAME = "AppDatabase.db"
        @Volatile
        private var instance : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase {
            if (instance == null){
                synchronized(this){
                    if(instance == null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }
            }
            return instance!!
        }

    }
}