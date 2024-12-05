package com.example.medicineapp.ui.util.model

import kotlinx.serialization.Serializable

@Serializable
data class ClassName(
    val associatedDrug: List<AssociatedDrug>? = listOf(),
    val associatedDrug2: List<AssociatedDrug>? = listOf()
)