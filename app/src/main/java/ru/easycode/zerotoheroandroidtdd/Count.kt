package ru.easycode.zerotoheroandroidtdd

import java.lang.IllegalStateException

interface Count {
    fun increment(number: String): String

    class Base(private val step: Int) : Count {

        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
        }
        override fun increment(number: String): String {
            val digit = number.toInt()
            val result = digit + step
            return result.toString()
        }

    }
}