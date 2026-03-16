package com.arabic.kamuslinguistik.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DatabaseSeeder2 {

    fun loadIstilahBagian2(context: Context): List<IstilahEntity2> {

        val jsonString = context.assets
            .open("istilah_bagian2.json")
            .bufferedReader()
            .use { it.readText() }

        val type = object : TypeToken<List<IstilahEntity2>>() {}.type

        return Gson().fromJson(jsonString, type)
    }
}