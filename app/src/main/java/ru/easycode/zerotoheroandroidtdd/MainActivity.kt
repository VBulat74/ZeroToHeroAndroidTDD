package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val count = Count.Base(2, 4)
    private var state : UiState = UiState.Base("0")

    private lateinit var textView: TextView
    private lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.countTextView)
        btn = findViewById<Button>(R.id.incrementButton)

        btn.setOnClickListener {
            state = count.increment(textView.text.toString())
            state.apply (textView, btn)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY) as UiState
        state.apply(textView, btn)
    }

    companion object {
        const val KEY = "key"
    }

}