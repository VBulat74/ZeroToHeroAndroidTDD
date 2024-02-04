package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progress = findViewById<ProgressBar>(R.id.progressBar)
        val btn = findViewById<Button>(R.id.actionButton)
        val textVierw = findViewById<TextView>(R.id.titleTextView)

        val scope = CoroutineScope(Dispatchers.Main)

        btn.setOnClickListener {
            btn.isEnabled = false
            progress.visibility = View.VISIBLE


            btn.postDelayed({
                textVierw.visibility = View.VISIBLE

                progress.visibility = View.GONE
                btn.isEnabled = true

            }, 3000)

//            scope.launch {
//                delay(3000)
//
//                textVierw.visibility = View.VISIBLE
//
//                progress.visibility = View.GONE
//                btn.isEnabled = true
//
//            }


        }
    }
}