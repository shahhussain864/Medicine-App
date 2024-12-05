package com.example.medicineapp.ui.util.retrofit


import com.example.medicineapp.ui.util.model.MedicineLIst
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    //Sign Up
    @GET("v3/41934ec7-8f71-45ad-9ce5-c631aeedbc4d")
    suspend fun getMedicineList(): MedicineLIst?


}