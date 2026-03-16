package com.arabic.kamuslinguistik.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DatabaseSeeder1 {

    fun loadIstilahBagian1(context: Context): List<IstilahEntity1> {

        val jsonString = context.assets
            .open("istilah_bagian1.json")
            .bufferedReader()
            .use { it.readText() }

        val type = object : TypeToken<List<IstilahEntity1>>() {}.type

        return Gson().fromJson(jsonString, type)
    }
}