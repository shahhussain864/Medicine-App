package com.sendcredit.ui.navigation

import com.example.medicineapp.ui.util.model.AssociatedDrug
import kotlinx.serialization.Serializable


@Serializable
object LogInScreenRoute

@Serializable
object MainScreenRoute

@Serializable
data class DetailScreenRoute(val name:String  , val dose:String , val strength:String)

