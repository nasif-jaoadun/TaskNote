package com.jnasif.tasknote.utilities

import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

class Utility {
    companion object{
        fun getDate(diff: Int):Date{
            val cal = GregorianCalendar()
            cal.add(Calendar.MILLISECOND, diff)
            return cal.time
        }
    }
}