package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private var state : State = State.Initial

    private lateinit var layout : LinearLayout
    private lateinit var textView : TextView
    private lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById<LinearLayout>(R.id.rootLayout)
        textView = findViewById<TextView>(R.id.titleTextView)
        btn = findViewById<Button>(R.id.removeButton)

        btn.setOnClickListener {
            state = State.Removed
            state.aplay(layout, textView, btn)
//            layout.removeView(textView)
//            btn.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        state = savedInstanceState.getSerializable(KEY) as State
        state.aplay(layout, textView, btn)
    }

    companion object {
        private const val KEY = "key"
    }

}

interface State : Serializable {
    fun aplay (linearLayout: LinearLayout, textView: TextView, btn: Button)

    object Initial : State {
        override fun aplay(linearLayout: LinearLayout, textView: TextView, btn: Button) {

        }

    }

    object Removed : State {
        override fun aplay(linearLayout: LinearLayout, textView: TextView, btn: Button) {
            linearLayout.removeView(textView)
            btn.isEnabled = false
        }

    }
}