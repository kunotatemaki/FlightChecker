package com.raul.androidapps.testapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raul.androidapps.testapplication.domain.model.Flights
import com.raul.androidapps.testapplication.network.ServerResult
import com.raul.androidapps.testapplication.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val result: MutableLiveData<ServerResult<Flights>> = MutableLiveData()
    private val loading: MutableLiveData<Boolean> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getLoading(): LiveData<Boolean> = loading

    fun getResult(): LiveData<ServerResult<Flights>> = result

    fun startFetchingFlightsAsync() {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val flights = repository.getFlights()
            loading.postValue(false)
            result.postValue(flights)
        }
    }
}
