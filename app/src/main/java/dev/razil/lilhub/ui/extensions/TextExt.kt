package dev.razil.lilhub.ui.extensions

import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import com.google.android.material.textfield.TextInputLayout

/** This is an Extension function to implement a TextChangedListener for EditText */
fun TextInputLayout.onChange(input: (String) -> Unit) {
    this.editText?.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            input(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}

/** This is an Extension function to get the string input for EditText */
fun TextInputLayout.text() = this.editText?.text.toString()

fun TextInputLayout.clear() = this.editText?.text?.clear()

fun TextInputLayout.onSubmit(input: (String) -> Unit) {
    this.editText?.setOnEditorActionListener { v, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            val s = v.text.toString()
            if (s.isNotBlank()) {
                input(v.text.toString())
            }
            true
        } else {
            false
        }
    }
}
