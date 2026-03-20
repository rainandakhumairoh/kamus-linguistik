package com.arabic.kamuslinguistik.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "istilah_bagian2")
data class IstilahEntity2(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

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