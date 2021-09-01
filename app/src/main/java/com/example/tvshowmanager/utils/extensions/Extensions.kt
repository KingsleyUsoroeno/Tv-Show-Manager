package com.example.tvshowmanager.utils.extensions

import android.view.View
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

val TextInputEditText.textString get() = this.text.toString().trim()

fun TextInputLayout.validate(errorMessage: String, validator: (text: String) -> Boolean): Boolean {
    return if (validator(this.editText?.text.toString().trim())) {
        this.error = null
        true
    } else {
        this.error = errorMessage
        false
    }
}

val Date.timeString: String
    get() {
        val simpleDateFormat = SimpleDateFormat(
            "MMMM dd yyyy",
            Locale.getDefault()
        )
        return simpleDateFormat.format(this)
    }

/**
 * Remove the view (visibility = View.GONE)
 */
val View.hide: View
    get() {
        if (visibility != View.GONE) {
            visibility = View.GONE
        }
        return this
    }

/**
 * Show the view  (visibility = View.VISIBLE)
 */
val View.show: View
    get() {
        if (visibility != View.VISIBLE) {
            visibility = View.VISIBLE
        }
        return this
    }