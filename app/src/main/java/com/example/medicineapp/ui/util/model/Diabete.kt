package com.example.medicineapp.ui.util.model

import kotlinx.serialization.Serializable

@Serializable
data class Diabete(
    val labs: List<Lab>? = listOf(),
    val medications: List<Medication>? = listOf()
)