package com.example.myapplication.code

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AppCategory {
    @SerialName("Games")
    GAMES,

    @SerialName("Social")
    SOCIAL,

    @SerialName("Networking")
    NETWORKING,

    @SerialName("Productivity")
    PRODUCTIVITY,

    @SerialName("Health & Fitness")
    HEALTHANDFITNESS,

    @SerialName("Education")
    EDCUTATION,

    @SerialName("Commercial")
    COMMERCIAL
}