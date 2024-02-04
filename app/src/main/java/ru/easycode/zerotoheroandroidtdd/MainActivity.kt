package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as App).viewModel

        val btn = findViewById<Button>(R.id.actionButton)
        val textView = findViewById<TextView>(R.id.titleTextView)
        val progress = findViewById<ProgressBar>(R.id.progressBar)

        btn.setOnClickListener {
            viewModel.load()
        }

        viewModel.lifDate().observe(this) {
            it.aply(btn, progress, textView)
        }

    }
}