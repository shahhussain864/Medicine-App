package com.example.medicineapp.ui.util.model

import kotlinx.serialization.Serializable

@Serializable
data class Medication(
    val medicationsClasses: List<MedicationsClasse>? = listOf()
)