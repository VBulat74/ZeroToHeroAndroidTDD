package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.countTextView)
        val btn = findViewById<Button>(R.id.incrementButton)

        btn.setOnClickListener {
            var value = textView.text.toString().toInt()
            value = value + 2
            textView.text = value.toString()
        }
    }
}