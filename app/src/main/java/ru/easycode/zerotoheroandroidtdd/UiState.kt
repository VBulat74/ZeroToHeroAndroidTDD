package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun apliy (btn: Button, progress : ProgressBar, textView: TextView)

    object ShowProgress : UiState {
        override fun apliy(btn: Button, progress: ProgressBar, textView: TextView) {
            btn.isEnabled = false
            progress.visibility = View.VISIBLE
        }
    }

    object ShowData : UiState {
        override fun apliy(btn: Button, progress: ProgressBar, textView: TextView) {
            btn.isEnabled = true
            progress.visibility = View.GONE
            textView.visibility = View.VISIBLE
        }
    }
}