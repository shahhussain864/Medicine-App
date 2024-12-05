package com.example.medicineapp.ui.util.model

import kotlinx.serialization.Serializable

@Serializable
data class MedicineLIst(
    val problems: List<Problem>? = listOf()
)