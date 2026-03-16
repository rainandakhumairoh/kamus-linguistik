package com.arabic.kamuslinguistik.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "istilah_bagian2")
data class IstilahEntity2(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val istilahLatin: String,
    val padananIndonesia: String,
    val padananArab: String,
    val padananInggris: String,
    val padananMandarin: String,
    val kategoriIstilah: String

)