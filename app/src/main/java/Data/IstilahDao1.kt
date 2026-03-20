package com.arabic.kamuslinguistik.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IstilahDao1 {

    @Query("SELECT * FROM istilah_bagian1 ORDER BY istilahLatin ASC")
    fun getAll(): Flow<List<IstilahEntity1>>

    @Query("SELECT COUNT(*) FROM istilah_bagian1")
    suspend fun countData(): Int

    @Insert
    suspend fun insertAll(data: List<IstilahEntity1>)

}

