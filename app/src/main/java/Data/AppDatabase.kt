package com.arabic.kamuslinguistik.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        IstilahEntity1::class,
        IstilahEntity2::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun istilahDao1(): IstilahDao1
    abstract fun istilahDao2(): IstilahDao2

}