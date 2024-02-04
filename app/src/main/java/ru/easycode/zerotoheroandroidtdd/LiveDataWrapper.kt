package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper : ProvideLiveDate {
    fun update(value: UiState)

    class Base (private val liveDate : MutableLiveData<UiState> = MutableLiveData()) : LiveDataWrapper {
        override fun update(value: UiState) {
            liveDate.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return liveDate
        }
    }
}

interface ProvideLiveDate{
    fun liveData(): LiveData<UiState>
}