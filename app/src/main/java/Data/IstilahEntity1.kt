package com.arabic.kamuslinguistik.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "istilah_bagian1")
data class IstilahEntity1(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val transkripsiArab: String,
    val arti: String,
    val penjelasan: String,
    val istilahArab: String,
    val kategoriIstilah: String
)