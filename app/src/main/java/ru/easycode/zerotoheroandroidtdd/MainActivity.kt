package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val count = Count.Base(step = 2,max = 4,min = 0)

    lateinit var textView: TextView
    lateinit var btn_inc : Button
    lateinit var btn_dec : Button

    var state : UiState = UiState.Min("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        btn_inc = findViewById(R.id.incrementButton)
        btn_dec = findViewById(R.id.decrementButton)

        state = count.initial("0")
        state.aply(textView, btn_inc,btn_dec)

        btn_inc.setOnClickListener {
            state = count.increment(textView.text.toString())
            state.aply(textView, btn_inc,btn_dec)
        }

        btn_dec.setOnClickListener {
            state = count.decrement(textView.text.toString())
            state.aply(textView, btn_inc,btn_dec)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        } else{
            savedInstanceState.getSerializable(KEY) as UiState
        }
        state.aply(textView, btn_inc,btn_dec)
    }

    companion object{
        private const val KEY = "key"
    }
}