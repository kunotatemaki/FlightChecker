package com.raul.androidapps.testapplication.ui.main

import androidx.lifecycle.ViewModel
import com.raul.androidapps.testapplication.domain.Resource
import com.raul.androidapps.testapplication.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    fun startFetchingFlightsAsync() {
        viewModelScope.launch(Dispatchers.IO) {
            val ratesResponse = repository.getFlights()
            if (ratesResponse.status == Resource.Status.SUCCESS) {
//                    updateObservableAsync(ratesResponse.data)
            }

        }
    }
}
