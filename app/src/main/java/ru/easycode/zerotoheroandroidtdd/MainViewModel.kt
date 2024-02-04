package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel (
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository,
) : ProvideLiveDate {

    private val scope = CoroutineScope(SupervisorJob()+Dispatchers.Main.immediate)

    fun lifDate() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        scope.launch {
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }

    }

    override fun liveData(): LiveData<UiState> = liveDataWrapper.liveData()


}