package com.arabic.kamuslinguistik.Page

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.content.Context

/**
 * ✅ SHARED DATA MODELS & FUNCTIONS
 *
 * File ini menyimpan semua data class dan helper functions
 * yang digunakan di DetailIstilah1, DetailIstilah2, dan Disimpan
 *
 * TUJUAN: Menghindari redeclaration dan conflicting overloads
 */

// ===== DATA CLASSES =====

/** Data class untuk detail istilah bagian 1 */
data class DetailIstilah1Data(
    val transkripsiArab: String,
    val arti: String,
    val penjelasan: String,
    val istilahArab: String,
    val kategoriIstilah: String
)

/** Data class untuk detail istilah bagian 2 */
data class DetailIstilah2Data(
    val istilahInggris: String,
    val prononInggris: String,
    val arti: String,
    val istilahArab: String,
    val transkripsiArab: String,
    val istilahMandarin: String,
    val transkripsiMandarin: String,
    val prononMandarin: String,
    val kategoriIstilah: String
)

/** Data class untuk saved istilah - HANYA SATU DEFINISI */
data class SavedIstilah(
    val id: String = System.currentTimeMillis().toString(),
    val istilahArab: String,
    val transkripsiArab: String,
    val arti: String,
    val kategoriIstilah: String,
    val source: String = "" // "Bagian1" atau "Bagian2"
)

// ===== HELPER FUNCTIONS - CENTRALIZED =====

/**
 * Simpan istilah ke SharedPreferences
 */
fun saveIstilahToPreferences(context: Context, istilah: SavedIstilah) {
    val prefs = context.getSharedPreferences("saved_istilah", Context.MODE_PRIVATE)
    val gson = Gson()

    // Ambil data yang sudah ada
    val existingJson = prefs.getString("istilah_list", "[]")
    val existingList = gson.fromJson<MutableList<SavedIstilah>>(
        existingJson,
        object : TypeToken<MutableList<SavedIstilah>>() {}.type
    ) ?: mutableListOf()

    // Cek apakah sudah ada
    val exists = existingList.any { it.istilahArab == istilah.istilahArab }
    if (!exists) {
        existingList.add(istilah)
        val newJson = gson.toJson(existingList)
        prefs.edit().putString("istilah_list", newJson).apply()
    }
}

/**
 * Hapus istilah dari SharedPreferences
 */
fun deleteIstilahFromPreferences(context: Context, istilahArab: String) {
    val prefs = context.getSharedPreferences("saved_istilah", Context.MODE_PRIVATE)
    val gson = Gson()

    val existingJson = prefs.getString("istilah_list", "[]")
    val existingList = gson.fromJson<MutableList<SavedIstilah>>(
        existingJson,
        object : TypeToken<MutableList<SavedIstilah>>() {}.type
    ) ?: mutableListOf()

    existingList.removeAll { it.istilahArab == istilahArab }
    val newJson = gson.toJson(existingList)
    prefs.edit().putString("istilah_list", newJson).apply()
}

/**
 * Cek apakah istilah sudah disimpan
 */
fun isIstilahSaved(context: Context, istilahArab: String): Boolean {
    val prefs = context.getSharedPreferences("saved_istilah", Context.MODE_PRIVATE)
    val gson = Gson()

    val existingJson = prefs.getString("istilah_list", "[]")
    val existingList = gson.fromJson<MutableList<SavedIstilah>>(
        existingJson,
        object : TypeToken<MutableList<SavedIstilah>>() {}.type
    ) ?: mutableListOf()

    return existingList.any { it.istilahArab == istilahArab }
}

/**
 * Ambil semua saved istilah
 */
fun getSavedIstilah(context: Context): List<SavedIstilah> {
    val prefs = context.getSharedPreferences("saved_istilah", Context.MODE_PRIVATE)
    val gson = Gson()

    val existingJson = prefs.getString("istilah_list", "[]")
    return gson.fromJson<MutableList<SavedIstilah>>(
        existingJson,
        object : TypeToken<MutableList<SavedIstilah>>() {}.type
    ) ?: mutableListOf()
}