package com.example.medicineapp.ui.util.model

import kotlinx.serialization.Serializable

@Serializable
data class AssociatedDrug(
    val dose: String? = "",
    val name: String? = "",
    val strength: String? = ""
)