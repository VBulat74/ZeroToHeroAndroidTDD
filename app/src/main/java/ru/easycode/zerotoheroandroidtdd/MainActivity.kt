package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel = MainViewModel(
        LiveDataWrapper.Base(),
        Repository.Base()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.titleTextView)
        val btn = findViewById<Button>(R.id.actionButton)
        val progress = findViewById<ProgressBar>(R.id.progressBar)

        btn.setOnClickListener {
            viewModel.load()
        }

        viewModel.liveDate().observe(this) { uiSate ->
            uiSate.apliy(btn, progress, textView)
        }

    }
}