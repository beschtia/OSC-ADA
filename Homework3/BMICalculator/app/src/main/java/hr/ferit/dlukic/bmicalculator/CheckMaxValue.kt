package hr.ferit.dlukic.bmicalculator

import android.text.Editable
import android.text.TextWatcher

class CheckMaxValue(private val max: Double) : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
        try {
            when {
                s.toString().toDouble() > max -> s?.replace(0, s.length, "$max")
            }
        }
        catch (nfe: NumberFormatException) {
        }

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}