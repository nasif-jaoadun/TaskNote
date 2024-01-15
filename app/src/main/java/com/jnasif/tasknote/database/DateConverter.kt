package com.jnasif.tasknote.database

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    companion object{
        @TypeConverter
        fun toDate(timeStamp : Long) : Date? {
            return if(timeStamp == null) {
                null
            } else Date(timeStamp)
        }

        @TypeConverter
        fun toTimeStamp(date: Date) : Long? {
            return if(date == null){
                null
            }else date.time
        }
    }
}