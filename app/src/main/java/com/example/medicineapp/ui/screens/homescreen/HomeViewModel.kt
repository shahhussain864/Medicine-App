package com.example.medicineapp.ui.screens.homescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicineapp.ui.util.model.MedicineLIst
import com.example.medicineapp.ui.util.retrofit.ApiService
import com.example.medicineapp.ui.util.room.UserInfo
import com.example.medicineapp.ui.util.room.dao.UserInfoDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userInfoDataSource: UserInfoDataSource,
    private val apiService: ApiService,

): ViewModel() {
    var userInfo: MutableState<UserInfo?> = mutableStateOf(null)
    val isDataLoaded: MutableState<Boolean> = mutableStateOf(false)
    val medicineData: MutableState<MedicineLIst?> = mutableStateOf(null)
    init {
        viewModelScope.launch {
            getUserData()
            getMedicineData()
        }
    }

   private suspend fun getUserData(){
        userInfo.value =  userInfoDataSource.getUser()
    }


   private suspend fun getMedicineData() {
        if(medicineData.value != null){
            return
        }
        else{

            try{
                val apiResponse =   apiService.getMedicineList()
                medicineData.value = apiResponse
            }catch (ex:Exception){

            }
            isDataLoaded.value  = true
        }
    }
}