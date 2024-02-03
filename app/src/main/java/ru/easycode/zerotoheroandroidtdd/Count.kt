package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {

        init {
            if (step < 2) {throw IllegalStateException("step should be positive, but was $step")}
            if (max < 1) {throw IllegalStateException("max should be positive, but was $max")}
            if (max<step) {throw IllegalStateException("max should be more than step")}
        }
        override fun increment(number: String): UiState {
            val digit = number.toInt()
            val result = digit + step
            return if (result+step <= max) {
                UiState.Base(result.toString())
            } else {
                UiState.Max(result.toString())
            }
        }
    }
}