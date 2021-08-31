package com.example.tvshowmanager.utils

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

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