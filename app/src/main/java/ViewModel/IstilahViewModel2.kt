package com.arabic.kamuslinguistik.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arabic.kamuslinguistik.data.DatabaseSeeder2
import com.arabic.kamuslinguistik.data.IstilahEntity2
import com.arabic.kamuslinguistik.data.IstilahDao2
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class IstilahViewModel2(
    private val dao: IstilahDao2
) : ViewModel() {

    fun seedDatabase2(context: Context) {

        viewModelScope.launch {

            val data = DatabaseSeeder2.loadIstilahBagian2(context)

            dao.insertAll(data)

        }

    }

    val istilahList2 = dao.getAll()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

}

