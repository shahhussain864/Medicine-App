package com.example.medicineapp.ui.screens.login

import androidx.lifecycle.ViewModel
import com.example.medicineapp.ui.util.room.UserInfo
import com.example.medicineapp.ui.util.room.dao.UserInfoDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val userInfoDataSource: UserInfoDataSource): ViewModel() {

    suspend fun saveDataToDb(name:String){
        userInfoDataSource.insertUser(UserInfo(name = name))
    }
}