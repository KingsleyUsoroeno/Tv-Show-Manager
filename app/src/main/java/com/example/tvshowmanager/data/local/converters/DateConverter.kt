package com.example.tvshowmanager.data.local.converters

import androidx.room.TypeConverter
import com.example.tvshowmanager.utils.Constants
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    private val sdf = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())

    @TypeConverter
    fun fromTimestamp(value: String): Date? {
        return sdf.parse(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): String? {
        return date?.let { sdf.format(it) }
    }
}