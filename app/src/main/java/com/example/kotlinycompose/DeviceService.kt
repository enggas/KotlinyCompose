package com.example.kotlinycompose

import retrofit2.http.GET

interface DeviceService {
    @GET(Constants.OBJECTS_PATH)
    suspend fun getAllDevices(): List<Dispositivos>

}