package com.ukejee.lushandroidtaskapplication.feature.launch

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import com.ukejee.lushandroidtaskapplication.data.api.Resource
import com.ukejee.lushandroidtaskapplication.data.api.Status
import com.ukejee.lushandroidtaskapplication.data.api.launch.LaunchRepositoryContract
import com.ukejee.lushandroidtaskapplication.data.api.launch.model.GetLaunchResponse
import com.ukejee.lushandroidtaskapplication.feature.launch.model.Launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LaunchListViewModel(
    private val repository: LaunchRepositoryContract,
    private val launchList: MutableLiveData<List<Launch>> = MutableLiveData(),
    private val isRefreshing: MutableLiveData<Boolean> = MutableLiveData(),
    private val errorMessage: MutableLiveData<String> = MutableLiveData(),
    private val errorMessageVisibility: MutableLiveData<Int> = MutableLiveData(),
) : ViewModel() {

    init {
        fetchLaunchList()
    }

    fun getErrorMessageVisibility(): LiveData<Int> = errorMessageVisibility

    fun getErrorMessage(): LiveData<String> = errorMessage

    fun getIsRefreshing(): LiveData<Boolean> = isRefreshing

    fun getLaunchList(): LiveData<List<Launch>> = launchList

    fun fetchLaunchList() {
        viewModelScope.launch {
            isRefreshing.value = true
            val response = repository.fetchAllLaunches()

            when(response.status) {
                Status.SUCCESS -> {
                    isRefreshing.value = false

                    if (response.data.isNullOrEmpty()) {
                        errorMessageVisibility.value = View.VISIBLE
                        errorMessage.value = "No Launch Found"

                    } else {
                        errorMessageVisibility.value = View.GONE
                        setLaunchList(response.data)
                    }
                }
                Status.ERROR -> {
                    isRefreshing.value = false
                    errorMessageVisibility.value = View.GONE
                }
            }
        }
    }

    fun setLaunchList(list: List<GetLaunchResponse>) {
        launchList.value = list.map {
            Launch.fromGetLaunchResponse(it)
        }
    }

//    fun fetchLaunchList() {
//        isRefreshing.value = true
//        viewModelScope.launch {
//            val response = repository.getAllLaunches()
//
//            when(response) {
//                is Resource.Success -> {
//                    isRefreshing.value = false
//                    val list = response.value.map {
//                        Launch.fromGetLaunchResponse(it)
//                    }
//                    launchList.value = list
//                }
//                is Resource.Failure -> {
//                    isRefreshing.value = false
//                    Log.d("******", "************ Something went wrong")
//                }
//            }
//        }
//    }


}