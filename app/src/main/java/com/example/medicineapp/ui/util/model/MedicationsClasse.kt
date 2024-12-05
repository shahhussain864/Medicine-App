package com.example.medicineapp.ui.util.model

import kotlinx.serialization.Serializable

@Serializable
data class MedicationsClasse(
    val className: List<ClassName>? = listOf(),
    val className2: List<ClassName>? = listOf()
)