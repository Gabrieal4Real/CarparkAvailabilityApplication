package com.gabrieal.carparkavailabilityapplication.network.api

import com.gabrieal.carparkavailabilityapplication.models.carpark.CarParkAvailabilityListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewAPIService {

    @GET(ApiRoutes.GET_AVAILABILITY)
    fun getAvailableParking(@Query("date_time") accessToken: String): Call<CarParkAvailabilityListModel>
}
