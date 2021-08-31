package com.example.tvshowmanager.data.local.converters

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    private val sdf = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

    @TypeConverter
    fun fromTimestamp(value: String): Date? {
        return sdf.parse(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): String? {
        return date?.let { sdf.format(it) }
    }
}