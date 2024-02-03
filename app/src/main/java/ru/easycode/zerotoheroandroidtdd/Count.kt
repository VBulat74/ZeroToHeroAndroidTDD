package ru.easycode.zerotoheroandroidtdd



interface Count {

    fun initial (number : String) : UiState
    fun increment (number : String) : UiState
    fun decrement (number : String) : UiState

    class Base(private val step: Int, private val max: Int, private val min: Int) : Count {

        init {
            if (step < 1) {throw IllegalStateException("step should be positive, but was $step")}
            if (max < 1) {throw IllegalStateException("max should be positive, but was $max")}
            if (max < step) {throw IllegalStateException("max should be more than step")}
            if (max < min) {throw IllegalStateException("max should be more than min")}
        }


        override fun initial(number: String): UiState {
            if (number.toInt() == min) return UiState.Min(min.toString())
            if (number.toInt() == max) return UiState.Max(max.toString())
            return UiState.Base(number)
        }

        override fun increment(number: String): UiState {
            val digit = number.toInt()
            return if (digit+step >= max)
                UiState.Max(max.toString())
            else
                UiState.Base ((digit+step).toString())

        }

        override fun decrement(number: String): UiState {
            val digit = number.toInt()

            return if (digit-step <= min)
                UiState.Min(min.toString())
            else
                UiState.Base((digit-step).toString())
        }

    }

}