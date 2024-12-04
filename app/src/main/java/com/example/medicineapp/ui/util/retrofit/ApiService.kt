package com.example.medicineapp.ui.util.retrofit


import com.example.medicineapp.ui.util.model.MedicineLIst
import retrofit2.http.POST


interface ApiService {
    //Sign Up
    @POST("v3/e3758201-a682-4ae0-8683-5db9f9996aa7")
    suspend fun getMedicineList(): MedicineLIst?


}