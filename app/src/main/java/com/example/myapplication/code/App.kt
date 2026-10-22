package com.example.myapplication.code

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class App(
    @SerialName("id")
    val id: Int,
    @SerialName("app_name")
    val appName: String,
    @SerialName("app_version")
    val appVersion: String,
    @SerialName("category")
    val category: AppCategory,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("developer_name")
    val developerName: String,
    @SerialName("rating")
    val rating: Double,
    @SerialName("downloads")
    val downloads: Int,
    @SerialName("description")
    val description: String,
    @SerialName("screenshots_link")
    val screenshotsLink: List<String>?,
    @SerialName("age")
    val age: Int,
    @SerialName("icon_link")
    val iconLink: String,


    )