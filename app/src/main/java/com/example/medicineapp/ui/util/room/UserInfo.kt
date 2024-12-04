package com.example.medicineapp.ui.util.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
data class UserInfo(
    @PrimaryKey
    val id:Int = 0 ,
    val name:String
)
