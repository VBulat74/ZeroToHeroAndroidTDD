package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.countTextView)
        val btn = findViewById<Button>(R.id.incrementButton)

        btn.setOnClickListener {
            val result= count.increment(textView.text.toString())

            textView.text = result
        }
    }
}