package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun aply(btn: Button, process: ProgressBar, textView: TextView)

    object ShowProgress : UiState {
        override fun aply(btn: Button, process: ProgressBar, textView: TextView) {
            textView.visibility = View.GONE
            btn.isEnabled = false
            process.visibility = View.VISIBLE
        }
    }

    object ShowData : UiState {
        override fun aply(btn: Button, process: ProgressBar, textView: TextView) {
            textView.visibility = View.VISIBLE
            btn.isEnabled = true
            process.visibility = View.GONE
        }
    }
}