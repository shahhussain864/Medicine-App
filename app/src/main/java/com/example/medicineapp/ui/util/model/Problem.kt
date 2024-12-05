package com.example.medicineapp.ui.util.model

import kotlinx.serialization.Serializable

@Serializable
data class Problem(
    val Asthma: List<Asthma>? = listOf(),
    val Diabetes: List<Diabete>? = listOf()
)