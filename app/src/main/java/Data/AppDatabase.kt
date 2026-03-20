package com.arabic.kamuslinguistik.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [IstilahEntity1::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun istilahDao1(): IstilahDao1

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "kamus_database"
                )
                    .fallbackToDestructiveMigration()  // ✅ TAMBAHAN INI
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}