package com.arabic.kamuslinguistik.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IstilahDao2 {

    @Query("SELECT * FROM istilah_bagian2 ORDER BY istilahLatin ASC")
    fun getAllIstilah(): Flow<List<IstilahEntity2>>

    @Insert
    suspend fun insertAll(data: List<IstilahEntity2>)

}