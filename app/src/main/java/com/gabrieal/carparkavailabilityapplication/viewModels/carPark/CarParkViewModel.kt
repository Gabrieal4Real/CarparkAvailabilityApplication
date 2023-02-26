package com.gabrieal.carparkavailabilityapplication.viewModels.carPark

import androidx.lifecycle.LiveData
import com.gabrieal.carparkavailabilityapplication.network.api.ResourceError

interface CarParkViewModel {
    fun getCarParkAvailability(dateTime: String)
    fun observeLoading(): LiveData<Boolean>
    fun observeError(): LiveData<ResourceError?>

    fun observeCarParkAvailability(): LiveData<Any?>

}