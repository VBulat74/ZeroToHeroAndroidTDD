package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun aply(
        textView: TextView,
        btn_inc: Button,
        btn_dec: Button
    )

    data class Min (private val text:String) : UiState {
        override fun aply(textView: TextView, btn_inc: Button, btn_dec: Button) {
            textView.text = text
            btn_dec.isEnabled = false
            btn_inc.isEnabled = true
        }

    }
    data class Max (private val text:String) : UiState {
        override fun aply(textView: TextView, btn_inc: Button, btn_dec: Button) {
            textView.text = text
            btn_dec.isEnabled = true
            btn_inc.isEnabled = false
        }

    }

    data class Base (private val text:String) : UiState {
        override fun aply(textView: TextView, btn_inc: Button, btn_dec: Button) {
            textView.text = text
            btn_dec.isEnabled = true
            btn_inc.isEnabled = true
        }

    }

}