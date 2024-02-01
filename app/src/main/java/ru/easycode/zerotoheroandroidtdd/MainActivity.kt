package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.contains

class MainActivity : AppCompatActivity() {

    lateinit var layout: LinearLayout
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn = findViewById<Button>(R.id.removeButton)
        layout = findViewById<LinearLayout>(R.id.rootLayout)
        textView = findViewById<TextView>(R.id.titleTextView)

        btn.setOnClickListener {
            layout.removeView(textView)
//            val contains1 = layout.contains(textView)
//            Log.d("AAA", "contains1 = ${contains1.toString()};")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val isRemovedTextView = !layout.contains(textView)
            outState.putBoolean(KEY, isRemovedTextView)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val isRemovedTextView = savedInstanceState.getBoolean(KEY)

        if (isRemovedTextView) {
            layout.removeView(textView)
        }
    }

    companion object {
        const val KEY = "key"
    }
}