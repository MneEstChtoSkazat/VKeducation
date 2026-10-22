package com.example.myapplication.repository

import android.content.Context
import com.example.myapplication.code.App
import kotlinx.serialization.json.Json

object Repository {

    var data = mutableListOf<App>()

    fun readData(context: Context): List<App> {
        val text = context.assets.open("APP_DATA.json").bufferedReader().readText()
        val array = Json.decodeFromString<List<App>>(text)
        data = Json.decodeFromString<MutableList<App>>(text)
        return array
    }
}