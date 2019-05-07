package com.sam43.performancetesting

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

object EmailValidator: TextWatcher {
    /**
 * Email validation pattern.
 */
     val EMAIL_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
        "\\@" +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
        "(" +
        "\\." +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
        ")+"
    )
    private var mIsValid = false

    fun isValid(): Boolean {
        return mIsValid
    }

    fun isValidEmail(email: CharSequence?): Boolean {
        return email != null && EMAIL_PATTERN.matcher(email).matches()
    }

    override fun afterTextChanged(editableText: Editable?) {
        mIsValid = isValidEmail(editableText)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {/*No-Op*/}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {/*No-Op*/}
}