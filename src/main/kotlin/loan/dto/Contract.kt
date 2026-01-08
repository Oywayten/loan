package com.example.loan.dto

import kotlinx.serialization.Serializable

@Serializable
data class Contract(val id: String, val clientId: String)
